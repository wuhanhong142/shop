package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.UserConverter;
import com.shop.model.UserDO;
import com.shop.entity.UserPO;
import com.shop.mapper.UserMapper;
import com.shop.repoistory.UserRepository;


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
public class UserRepositoryImpl extends RepositoryImpl<UserMapper, UserPO, UserConverter, UserDO> implements UserRepository {


    @Override
    public List<UserDO> findByModel(UserDO userDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<UserPO> wapper = wapper(userDO);
        wapper.last(lastSql);

        List<UserPO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(UserDO userDO) {
        return wapper(userDO).count();
    }

    private LambdaQueryChainWrapper<UserPO> wapper(UserDO userDO) {
        LambdaQueryChainWrapper<UserPO> query = lambdaQuery();
        if (userDO != null) {
            query.eq(Objects.nonNull(userDO.getGmtCreate()), UserPO::getGmtCreate, userDO.getGmtCreate());
            query.eq(Objects.nonNull(userDO.getCreateBy()), UserPO::getCreateBy, userDO.getCreateBy());
            query.eq(Objects.nonNull(userDO.getGmtModified()), UserPO::getGmtModified, userDO.getGmtModified());
            query.eq(Objects.nonNull(userDO.getUpdateBy()), UserPO::getUpdateBy, userDO.getUpdateBy());
            query.eq(Objects.nonNull(userDO.getCompanyId()), UserPO::getCompanyId, userDO.getCompanyId());
            query.eq(Objects.nonNull(userDO.getName()), UserPO::getName, userDO.getName());
            query.eq(Objects.nonNull(userDO.getLoginMobile()), UserPO::getLoginMobile, userDO.getLoginMobile());
            query.eq(Objects.nonNull(userDO.getPassword()), UserPO::getPassword, userDO.getPassword());
        }
        return query;
    }
}

