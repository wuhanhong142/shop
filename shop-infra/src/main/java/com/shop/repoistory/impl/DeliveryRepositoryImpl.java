package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.DeliveryConverter;
import com.shop.model.DeliveryDO;
import com.shop.entity.DeliveryPO;
import com.shop.mapper.DeliveryMapper;
import com.shop.repoistory.DeliveryRepository;


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
public class DeliveryRepositoryImpl extends RepositoryImpl<DeliveryMapper, DeliveryPO, DeliveryConverter, DeliveryDO> implements DeliveryRepository {


    @Override
    public List<DeliveryDO> findByModel(DeliveryDO deliveryDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<DeliveryPO> wapper = wapper(deliveryDO);
        wapper.last(lastSql);

        List<DeliveryPO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(DeliveryDO deliveryDO) {
        return wapper(deliveryDO).count();
    }

    private LambdaQueryChainWrapper<DeliveryPO> wapper(DeliveryDO deliveryDO) {
        LambdaQueryChainWrapper<DeliveryPO> query = lambdaQuery();
        if (deliveryDO != null) {
            query.eq(Objects.nonNull(deliveryDO.getGmtCreate()), DeliveryPO::getGmtCreate, deliveryDO.getGmtCreate());
            query.eq(Objects.nonNull(deliveryDO.getCreateBy()), DeliveryPO::getCreateBy, deliveryDO.getCreateBy());
            query.eq(Objects.nonNull(deliveryDO.getGmtModified()), DeliveryPO::getGmtModified, deliveryDO.getGmtModified());
            query.eq(Objects.nonNull(deliveryDO.getUpdateBy()), DeliveryPO::getUpdateBy, deliveryDO.getUpdateBy());
            query.eq(Objects.nonNull(deliveryDO.getOrderId()), DeliveryPO::getOrderId, deliveryDO.getOrderId());
            query.eq(Objects.nonNull(deliveryDO.getDeliveryStatus()), DeliveryPO::getDeliveryStatus, deliveryDO.getDeliveryStatus());
        }
        return query;
    }
}

