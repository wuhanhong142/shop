package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.InvoiceConverter;
import com.shop.model.InvoiceDO;
import com.shop.entity.InvoicePO;
import com.shop.mapper.InvoiceMapper;
import com.shop.repoistory.InvoiceRepository;


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
public class InvoiceRepositoryImpl extends RepositoryImpl<InvoiceMapper, InvoicePO, InvoiceConverter, InvoiceDO> implements InvoiceRepository {


    @Override
    public List<InvoiceDO> findByModel(InvoiceDO invoiceDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<InvoicePO> wapper = wapper(invoiceDO);
        wapper.last(lastSql);

        List<InvoicePO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(InvoiceDO invoiceDO) {
        return wapper(invoiceDO).count();
    }

    private LambdaQueryChainWrapper<InvoicePO> wapper(InvoiceDO invoiceDO) {
        LambdaQueryChainWrapper<InvoicePO> query = lambdaQuery();
        if (invoiceDO != null) {
            query.eq(Objects.nonNull(invoiceDO.getGmtCreate()), InvoicePO::getGmtCreate, invoiceDO.getGmtCreate());
            query.eq(Objects.nonNull(invoiceDO.getCreateBy()), InvoicePO::getCreateBy, invoiceDO.getCreateBy());
            query.eq(Objects.nonNull(invoiceDO.getGmtModified()), InvoicePO::getGmtModified, invoiceDO.getGmtModified());
            query.eq(Objects.nonNull(invoiceDO.getUpdateBy()), InvoicePO::getUpdateBy, invoiceDO.getUpdateBy());
            query.eq(Objects.nonNull(invoiceDO.getIsVat()), InvoicePO::getIsVat, invoiceDO.getIsVat());
            query.eq(Objects.nonNull(invoiceDO.getTitle()), InvoicePO::getTitle, invoiceDO.getTitle());
            query.eq(Objects.nonNull(invoiceDO.getContent()), InvoicePO::getContent, invoiceDO.getContent());
            query.eq(Objects.nonNull(invoiceDO.getAmount()), InvoicePO::getAmount, invoiceDO.getAmount());
            query.eq(Objects.nonNull(invoiceDO.getTaxNo()), InvoicePO::getTaxNo, invoiceDO.getTaxNo());
            query.eq(Objects.nonNull(invoiceDO.getTax()), InvoicePO::getTax, invoiceDO.getTax());
            query.eq(Objects.nonNull(invoiceDO.getCompanyName()), InvoicePO::getCompanyName, invoiceDO.getCompanyName());
            query.eq(Objects.nonNull(invoiceDO.getCompanyAddress()), InvoicePO::getCompanyAddress, invoiceDO.getCompanyAddress());
            query.eq(Objects.nonNull(invoiceDO.getPhone()), InvoicePO::getPhone, invoiceDO.getPhone());
            query.eq(Objects.nonNull(invoiceDO.getBankName()), InvoicePO::getBankName, invoiceDO.getBankName());
            query.eq(Objects.nonNull(invoiceDO.getBankAccount()), InvoicePO::getBankAccount, invoiceDO.getBankAccount());
        }
        return query;
    }
}

