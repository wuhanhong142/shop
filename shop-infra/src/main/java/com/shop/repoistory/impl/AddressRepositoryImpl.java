package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.AddressConverter;
import com.shop.model.AddressDO;
import com.shop.entity.AddressPO;
import com.shop.mapper.AddressMapper;
import com.shop.repoistory.AddressRepository;


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
public class AddressRepositoryImpl extends RepositoryImpl<AddressMapper, AddressPO, AddressConverter, AddressDO> implements AddressRepository {


    @Override
    public List<AddressDO> findByModel(AddressDO addressDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<AddressPO> wapper = wapper(addressDO);
        wapper.last(lastSql);

        List<AddressPO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(AddressDO addressDO) {
        return wapper(addressDO).count();
    }

    private LambdaQueryChainWrapper<AddressPO> wapper(AddressDO addressDO) {
        LambdaQueryChainWrapper<AddressPO> query = lambdaQuery();
        if (addressDO != null) {
            query.eq(Objects.nonNull(addressDO.getGmtCreate()), AddressPO::getGmtCreate, addressDO.getGmtCreate());
            query.eq(Objects.nonNull(addressDO.getCreateBy()), AddressPO::getCreateBy, addressDO.getCreateBy());
            query.eq(Objects.nonNull(addressDO.getGmtModified()), AddressPO::getGmtModified, addressDO.getGmtModified());
            query.eq(Objects.nonNull(addressDO.getUpdateBy()), AddressPO::getUpdateBy, addressDO.getUpdateBy());
            query.eq(Objects.nonNull(addressDO.getProvince()), AddressPO::getProvince, addressDO.getProvince());
            query.eq(Objects.nonNull(addressDO.getCity()), AddressPO::getCity, addressDO.getCity());
            query.eq(Objects.nonNull(addressDO.getArea()), AddressPO::getArea, addressDO.getArea());
            query.eq(Objects.nonNull(addressDO.getTown()), AddressPO::getTown, addressDO.getTown());
            query.eq(Objects.nonNull(addressDO.getDetail()), AddressPO::getDetail, addressDO.getDetail());
            query.eq(Objects.nonNull(addressDO.getPhone()), AddressPO::getPhone, addressDO.getPhone());
            query.eq(Objects.nonNull(addressDO.getConsignee()), AddressPO::getConsignee, addressDO.getConsignee());
        }
        return query;
    }
}

