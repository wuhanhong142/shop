package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.CompanyConverter;
import com.shop.model.CompanyDO;
import com.shop.entity.CompanyPO;
import com.shop.mapper.CompanyMapper;
import com.shop.repoistory.CompanyRepository;


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
public class CompanyRepositoryImpl extends RepositoryImpl<CompanyMapper, CompanyPO, CompanyConverter, CompanyDO> implements CompanyRepository {


    @Override
    public List<CompanyDO> findByModel(CompanyDO companyDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<CompanyPO> wapper = wapper(companyDO);
        wapper.last(lastSql);

        List<CompanyPO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(CompanyDO companyDO) {
        return wapper(companyDO).count();
    }

    private LambdaQueryChainWrapper<CompanyPO> wapper(CompanyDO companyDO) {
        LambdaQueryChainWrapper<CompanyPO> query = lambdaQuery();
        if (companyDO != null) {
            query.eq(Objects.nonNull(companyDO.getGmtCreate()), CompanyPO::getGmtCreate, companyDO.getGmtCreate());
            query.eq(Objects.nonNull(companyDO.getCreateBy()), CompanyPO::getCreateBy, companyDO.getCreateBy());
            query.eq(Objects.nonNull(companyDO.getGmtModified()), CompanyPO::getGmtModified, companyDO.getGmtModified());
            query.eq(Objects.nonNull(companyDO.getUpdateBy()), CompanyPO::getUpdateBy, companyDO.getUpdateBy());
            query.eq(Objects.nonNull(companyDO.getName()), CompanyPO::getName, companyDO.getName());
            query.eq(Objects.nonNull(companyDO.getSocialCode()), CompanyPO::getSocialCode, companyDO.getSocialCode());
            query.eq(Objects.nonNull(companyDO.getLegalName()), CompanyPO::getLegalName, companyDO.getLegalName());
            query.eq(Objects.nonNull(companyDO.getEstablishDate()), CompanyPO::getEstablishDate, companyDO.getEstablishDate());
        }
        return query;
    }
}

