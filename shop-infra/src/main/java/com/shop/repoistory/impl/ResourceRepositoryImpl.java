package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.ResourceConverter;
import com.shop.model.ResourceDO;
import com.shop.entity.ResourcePO;
import com.shop.mapper.ResourceMapper;
import com.shop.repoistory.ResourceRepository;


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
public class ResourceRepositoryImpl extends RepositoryImpl<ResourceMapper, ResourcePO, ResourceConverter, ResourceDO> implements ResourceRepository {


    @Override
    public List<ResourceDO> findByModel(ResourceDO resourceDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<ResourcePO> wapper = wapper(resourceDO);
        wapper.last(lastSql);

        List<ResourcePO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(ResourceDO resourceDO) {
        return wapper(resourceDO).count();
    }

    private LambdaQueryChainWrapper<ResourcePO> wapper(ResourceDO resourceDO) {
        LambdaQueryChainWrapper<ResourcePO> query = lambdaQuery();
        if (resourceDO != null) {
            query.eq(Objects.nonNull(resourceDO.getGmtCreate()), ResourcePO::getGmtCreate, resourceDO.getGmtCreate());
            query.eq(Objects.nonNull(resourceDO.getCreateBy()), ResourcePO::getCreateBy, resourceDO.getCreateBy());
            query.eq(Objects.nonNull(resourceDO.getGmtModified()), ResourcePO::getGmtModified, resourceDO.getGmtModified());
            query.eq(Objects.nonNull(resourceDO.getUpdateBy()), ResourcePO::getUpdateBy, resourceDO.getUpdateBy());
            query.eq(Objects.nonNull(resourceDO.getParentId()), ResourcePO::getParentId, resourceDO.getParentId());
            query.eq(Objects.nonNull(resourceDO.getUrl()), ResourcePO::getUrl, resourceDO.getUrl());
            query.eq(Objects.nonNull(resourceDO.getIcon()), ResourcePO::getIcon, resourceDO.getIcon());
        }
        return query;
    }
}

