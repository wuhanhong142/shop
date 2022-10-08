package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.ShopUserConverter;
import com.shop.model.ShopUserDO;
import com.shop.entity.ShopUserPO;
import com.shop.mapper.ShopUserMapper;
import com.shop.repoistory.ShopUserRepository;


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
public class ShopUserRepositoryImpl extends RepositoryImpl<ShopUserMapper, ShopUserPO, ShopUserConverter, ShopUserDO> implements ShopUserRepository {


    @Override
    public List<ShopUserDO> findByModel(ShopUserDO shopUserDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<ShopUserPO> wapper = wapper(shopUserDO);
        wapper.last(lastSql);

        List<ShopUserPO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(ShopUserDO shopUserDO) {
        return wapper(shopUserDO).count();
    }

    private LambdaQueryChainWrapper<ShopUserPO> wapper(ShopUserDO shopUserDO) {
        LambdaQueryChainWrapper<ShopUserPO> query = lambdaQuery();
        if (shopUserDO != null) {
            query.eq(Objects.nonNull(shopUserDO.getGmtCreate()), ShopUserPO::getGmtCreate, shopUserDO.getGmtCreate());
            query.eq(Objects.nonNull(shopUserDO.getCreateBy()), ShopUserPO::getCreateBy, shopUserDO.getCreateBy());
            query.eq(Objects.nonNull(shopUserDO.getGmtModified()), ShopUserPO::getGmtModified, shopUserDO.getGmtModified());
            query.eq(Objects.nonNull(shopUserDO.getUpdateBy()), ShopUserPO::getUpdateBy, shopUserDO.getUpdateBy());
            query.eq(Objects.nonNull(shopUserDO.getShopId()), ShopUserPO::getShopId, shopUserDO.getShopId());
            query.eq(Objects.nonNull(shopUserDO.getName()), ShopUserPO::getName, shopUserDO.getName());
            query.eq(Objects.nonNull(shopUserDO.getLoginMobile()), ShopUserPO::getLoginMobile, shopUserDO.getLoginMobile());
            query.eq(Objects.nonNull(shopUserDO.getPassword()), ShopUserPO::getPassword, shopUserDO.getPassword());
        }
        return query;
    }
}

