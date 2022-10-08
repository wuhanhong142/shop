package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.OrderConverter;
import com.shop.model.OrderDO;
import com.shop.entity.OrderPO;
import com.shop.mapper.OrderMapper;
import com.shop.repoistory.OrderRepository;


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
public class OrderRepositoryImpl extends RepositoryImpl<OrderMapper, OrderPO, OrderConverter, OrderDO> implements OrderRepository {


    @Override
    public List<OrderDO> findByModel(OrderDO orderDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<OrderPO> wapper = wapper(orderDO);
        wapper.last(lastSql);

        List<OrderPO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(OrderDO orderDO) {
        return wapper(orderDO).count();
    }

    private LambdaQueryChainWrapper<OrderPO> wapper(OrderDO orderDO) {
        LambdaQueryChainWrapper<OrderPO> query = lambdaQuery();
        if (orderDO != null) {
            query.eq(Objects.nonNull(orderDO.getGmtCreate()), OrderPO::getGmtCreate, orderDO.getGmtCreate());
            query.eq(Objects.nonNull(orderDO.getCreateBy()), OrderPO::getCreateBy, orderDO.getCreateBy());
            query.eq(Objects.nonNull(orderDO.getGmtModified()), OrderPO::getGmtModified, orderDO.getGmtModified());
            query.eq(Objects.nonNull(orderDO.getUpdateBy()), OrderPO::getUpdateBy, orderDO.getUpdateBy());
            query.eq(Objects.nonNull(orderDO.getShopId()), OrderPO::getShopId, orderDO.getShopId());
            query.eq(Objects.nonNull(orderDO.getUserId()), OrderPO::getUserId, orderDO.getUserId());
            query.eq(Objects.nonNull(orderDO.getAddressId()), OrderPO::getAddressId, orderDO.getAddressId());
            query.eq(Objects.nonNull(orderDO.getInvoiceId()), OrderPO::getInvoiceId, orderDO.getInvoiceId());
            query.eq(Objects.nonNull(orderDO.getAmount()), OrderPO::getAmount, orderDO.getAmount());
            query.eq(Objects.nonNull(orderDO.getDiscountAmount()), OrderPO::getDiscountAmount, orderDO.getDiscountAmount());
            query.eq(Objects.nonNull(orderDO.getDeliveryAmount()), OrderPO::getDeliveryAmount, orderDO.getDeliveryAmount());
            query.eq(Objects.nonNull(orderDO.getTotalAmount()), OrderPO::getTotalAmount, orderDO.getTotalAmount());
            query.eq(Objects.nonNull(orderDO.getCreateTime()), OrderPO::getCreateTime, orderDO.getCreateTime());
            query.eq(Objects.nonNull(orderDO.getShippingTime()), OrderPO::getShippingTime, orderDO.getShippingTime());
            query.eq(Objects.nonNull(orderDO.getPayTime()), OrderPO::getPayTime, orderDO.getPayTime());
            query.eq(Objects.nonNull(orderDO.getReceiveTime()), OrderPO::getReceiveTime, orderDO.getReceiveTime());
            query.eq(Objects.nonNull(orderDO.getOrderStatus()), OrderPO::getOrderStatus, orderDO.getOrderStatus());
            query.eq(Objects.nonNull(orderDO.getRemark()), OrderPO::getRemark, orderDO.getRemark());
        }
        return query;
    }
}

