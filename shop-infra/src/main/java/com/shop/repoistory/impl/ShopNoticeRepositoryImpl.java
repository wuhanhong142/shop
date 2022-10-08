package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.ShopNoticeConverter;
import com.shop.model.ShopNoticeDO;
import com.shop.entity.ShopNoticePO;
import com.shop.mapper.ShopNoticeMapper;
import com.shop.repoistory.ShopNoticeRepository;


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
public class ShopNoticeRepositoryImpl extends RepositoryImpl<ShopNoticeMapper, ShopNoticePO, ShopNoticeConverter, ShopNoticeDO> implements ShopNoticeRepository {


    @Override
    public List<ShopNoticeDO> findByModel(ShopNoticeDO shopNoticeDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<ShopNoticePO> wapper = wapper(shopNoticeDO);
        wapper.last(lastSql);

        List<ShopNoticePO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(ShopNoticeDO shopNoticeDO) {
        return wapper(shopNoticeDO).count();
    }

    private LambdaQueryChainWrapper<ShopNoticePO> wapper(ShopNoticeDO shopNoticeDO) {
        LambdaQueryChainWrapper<ShopNoticePO> query = lambdaQuery();
        if (shopNoticeDO != null) {
            query.eq(Objects.nonNull(shopNoticeDO.getShopId()), ShopNoticePO::getShopId, shopNoticeDO.getShopId());
            query.eq(Objects.nonNull(shopNoticeDO.getContent()), ShopNoticePO::getContent, shopNoticeDO.getContent());
        }
        return query;
    }
}

