package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.RoleConverter;
import com.shop.model.RoleDO;
import com.shop.entity.RolePO;
import com.shop.mapper.RoleMapper;
import com.shop.repoistory.RoleRepository;


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
public class RoleRepositoryImpl extends RepositoryImpl<RoleMapper, RolePO, RoleConverter, RoleDO> implements RoleRepository {


    @Override
    public List<RoleDO> findByModel(RoleDO roleDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<RolePO> wapper = wapper(roleDO);
        wapper.last(lastSql);

        List<RolePO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(RoleDO roleDO) {
        return wapper(roleDO).count();
    }

    private LambdaQueryChainWrapper<RolePO> wapper(RoleDO roleDO) {
        LambdaQueryChainWrapper<RolePO> query = lambdaQuery();
        if (roleDO != null) {
            query.eq(Objects.nonNull(roleDO.getGmtCreate()), RolePO::getGmtCreate, roleDO.getGmtCreate());
            query.eq(Objects.nonNull(roleDO.getCreateBy()), RolePO::getCreateBy, roleDO.getCreateBy());
            query.eq(Objects.nonNull(roleDO.getGmtModified()), RolePO::getGmtModified, roleDO.getGmtModified());
            query.eq(Objects.nonNull(roleDO.getUpdateBy()), RolePO::getUpdateBy, roleDO.getUpdateBy());
            query.eq(Objects.nonNull(roleDO.getRoleName()), RolePO::getRoleName, roleDO.getRoleName());
        }
        return query;
    }
}

