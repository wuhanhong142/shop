package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.ShopConverter;
import com.shop.model.ShopDO;
import com.shop.entity.ShopPO;
import com.shop.mapper.ShopMapper;
import com.shop.repoistory.ShopRepository;


import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;

@Slf4j
@Repository
public class ShopRepositoryImpl extends RepositoryImpl<ShopMapper, ShopPO, ShopConverter, ShopDO> implements ShopRepository {


    @Override
    public List<ShopDO> findByModel(ShopDO shopDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<ShopPO> wapper = wapper(shopDO);
        wapper.last(lastSql);

        List<ShopPO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(ShopDO shopDO) {
        return wapper(shopDO).count();
    }

    private LambdaQueryChainWrapper<ShopPO> wapper(ShopDO shopDO) {
        LambdaQueryChainWrapper<ShopPO> query = lambdaQuery();
        if (shopDO != null) {
            query.eq(Objects.nonNull(shopDO.getGmtCreate()), ShopPO::getGmtCreate, shopDO.getGmtCreate());
            query.eq(Objects.nonNull(shopDO.getCreateBy()), ShopPO::getCreateBy, shopDO.getCreateBy());
            query.eq(Objects.nonNull(shopDO.getGmtModified()), ShopPO::getGmtModified, shopDO.getGmtModified());
            query.eq(Objects.nonNull(shopDO.getUpdateBy()), ShopPO::getUpdateBy, shopDO.getUpdateBy());
            query.eq(Objects.nonNull(shopDO.getName()), ShopPO::getName, shopDO.getName());
            query.eq(Objects.nonNull(shopDO.getMoqAmount()), ShopPO::getMoqAmount, shopDO.getMoqAmount());
            query.eq(Objects.nonNull(shopDO.getFreight()), ShopPO::getFreight, shopDO.getFreight());
            query.eq(Objects.nonNull(shopDO.getAddress()), ShopPO::getAddress, shopDO.getAddress());
            query.eq(Objects.nonNull(shopDO.getPhone()), ShopPO::getPhone, shopDO.getPhone());
            query.eq(Objects.nonNull(shopDO.getTradeStart()), ShopPO::getTradeStart, shopDO.getTradeStart());
            query.eq(Objects.nonNull(shopDO.getTradeEnd()), ShopPO::getTradeEnd, shopDO.getTradeEnd());
        }
        return query;
    }
}

