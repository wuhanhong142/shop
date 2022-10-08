package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.OrderItemConverter;
import com.shop.model.OrderItemDO;
import com.shop.entity.OrderItemPO;
import com.shop.mapper.OrderItemMapper;
import com.shop.repoistory.OrderItemRepository;


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
public class OrderItemRepositoryImpl extends RepositoryImpl<OrderItemMapper, OrderItemPO, OrderItemConverter, OrderItemDO> implements OrderItemRepository {


    @Override
    public List<OrderItemDO> findByModel(OrderItemDO orderItemDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<OrderItemPO> wapper = wapper(orderItemDO);
        wapper.last(lastSql);

        List<OrderItemPO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(OrderItemDO orderItemDO) {
        return wapper(orderItemDO).count();
    }

    private LambdaQueryChainWrapper<OrderItemPO> wapper(OrderItemDO orderItemDO) {
        LambdaQueryChainWrapper<OrderItemPO> query = lambdaQuery();
        if (orderItemDO != null) {
            query.eq(Objects.nonNull(orderItemDO.getGmtCreate()), OrderItemPO::getGmtCreate, orderItemDO.getGmtCreate());
            query.eq(Objects.nonNull(orderItemDO.getCreateBy()), OrderItemPO::getCreateBy, orderItemDO.getCreateBy());
            query.eq(Objects.nonNull(orderItemDO.getGmtModified()), OrderItemPO::getGmtModified, orderItemDO.getGmtModified());
            query.eq(Objects.nonNull(orderItemDO.getUpdateBy()), OrderItemPO::getUpdateBy, orderItemDO.getUpdateBy());
            query.eq(Objects.nonNull(orderItemDO.getOrderId()), OrderItemPO::getOrderId, orderItemDO.getOrderId());
            query.eq(Objects.nonNull(orderItemDO.getGoodId()), OrderItemPO::getGoodId, orderItemDO.getGoodId());
            query.eq(Objects.nonNull(orderItemDO.getGoodName()), OrderItemPO::getGoodName, orderItemDO.getGoodName());
            query.eq(Objects.nonNull(orderItemDO.getGoodCnt()), OrderItemPO::getGoodCnt, orderItemDO.getGoodCnt());
            query.eq(Objects.nonNull(orderItemDO.getGoodPrice()), OrderItemPO::getGoodPrice, orderItemDO.getGoodPrice());
            query.eq(Objects.nonNull(orderItemDO.getFeeMoney()), OrderItemPO::getFeeMoney, orderItemDO.getFeeMoney());
        }
        return query;
    }
}

