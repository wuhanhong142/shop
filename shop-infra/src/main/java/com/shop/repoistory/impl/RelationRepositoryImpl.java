package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.RelationConverter;
import com.shop.model.RelationDO;
import com.shop.entity.RelationPO;
import com.shop.mapper.RelationMapper;
import com.shop.repoistory.RelationRepository;


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
public class RelationRepositoryImpl extends RepositoryImpl<RelationMapper, RelationPO, RelationConverter, RelationDO> implements RelationRepository {


    @Override
    public List<RelationDO> findByModel(RelationDO relationDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<RelationPO> wapper = wapper(relationDO);
        wapper.last(lastSql);

        List<RelationPO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(RelationDO relationDO) {
        return wapper(relationDO).count();
    }

    private LambdaQueryChainWrapper<RelationPO> wapper(RelationDO relationDO) {
        LambdaQueryChainWrapper<RelationPO> query = lambdaQuery();
        if (relationDO != null) {
            query.eq(Objects.nonNull(relationDO.getGmtCreate()), RelationPO::getGmtCreate, relationDO.getGmtCreate());
            query.eq(Objects.nonNull(relationDO.getCreateBy()), RelationPO::getCreateBy, relationDO.getCreateBy());
            query.eq(Objects.nonNull(relationDO.getGmtModified()), RelationPO::getGmtModified, relationDO.getGmtModified());
            query.eq(Objects.nonNull(relationDO.getUpdateBy()), RelationPO::getUpdateBy, relationDO.getUpdateBy());
            query.eq(Objects.nonNull(relationDO.getUserId()), RelationPO::getUserId, relationDO.getUserId());
            query.eq(Objects.nonNull(relationDO.getRoleId()), RelationPO::getRoleId, relationDO.getRoleId());
            query.eq(Objects.nonNull(relationDO.getResourceId()), RelationPO::getResourceId, relationDO.getResourceId());
        }
        return query;
    }
}

