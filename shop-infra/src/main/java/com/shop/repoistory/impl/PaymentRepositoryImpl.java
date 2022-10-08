package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.PaymentConverter;
import com.shop.model.PaymentDO;
import com.shop.entity.PaymentPO;
import com.shop.mapper.PaymentMapper;
import com.shop.repoistory.PaymentRepository;


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
public class PaymentRepositoryImpl extends RepositoryImpl<PaymentMapper, PaymentPO, PaymentConverter, PaymentDO> implements PaymentRepository {


    @Override
    public List<PaymentDO> findByModel(PaymentDO paymentDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<PaymentPO> wapper = wapper(paymentDO);
        wapper.last(lastSql);

        List<PaymentPO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(PaymentDO paymentDO) {
        return wapper(paymentDO).count();
    }

    private LambdaQueryChainWrapper<PaymentPO> wapper(PaymentDO paymentDO) {
        LambdaQueryChainWrapper<PaymentPO> query = lambdaQuery();
        if (paymentDO != null) {
            query.eq(Objects.nonNull(paymentDO.getGmtCreate()), PaymentPO::getGmtCreate, paymentDO.getGmtCreate());
            query.eq(Objects.nonNull(paymentDO.getCreateBy()), PaymentPO::getCreateBy, paymentDO.getCreateBy());
            query.eq(Objects.nonNull(paymentDO.getGmtModified()), PaymentPO::getGmtModified, paymentDO.getGmtModified());
            query.eq(Objects.nonNull(paymentDO.getUpdateBy()), PaymentPO::getUpdateBy, paymentDO.getUpdateBy());
            query.eq(Objects.nonNull(paymentDO.getOrderId()), PaymentPO::getOrderId, paymentDO.getOrderId());
            query.eq(Objects.nonNull(paymentDO.getAmount()), PaymentPO::getAmount, paymentDO.getAmount());
            query.eq(Objects.nonNull(paymentDO.getChannel()), PaymentPO::getChannel, paymentDO.getChannel());
            query.eq(Objects.nonNull(paymentDO.getPayStatus()), PaymentPO::getPayStatus, paymentDO.getPayStatus());
            query.eq(Objects.nonNull(paymentDO.getRemark()), PaymentPO::getRemark, paymentDO.getRemark());
        }
        return query;
    }
}

