package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.CategoryConverter;
import com.shop.model.CategoryDO;
import com.shop.entity.CategoryPO;
import com.shop.mapper.CategoryMapper;
import com.shop.repoistory.CategoryRepository;


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
public class CategoryRepositoryImpl extends RepositoryImpl<CategoryMapper, CategoryPO, CategoryConverter, CategoryDO> implements CategoryRepository {


    @Override
    public List<CategoryDO> findByModel(CategoryDO categoryDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<CategoryPO> wapper = wapper(categoryDO);
        wapper.last(lastSql);

        List<CategoryPO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(CategoryDO categoryDO) {
        return wapper(categoryDO).count();
    }

    private LambdaQueryChainWrapper<CategoryPO> wapper(CategoryDO categoryDO) {
        LambdaQueryChainWrapper<CategoryPO> query = lambdaQuery();
        if (categoryDO != null) {
            query.eq(Objects.nonNull(categoryDO.getGmtCreate()), CategoryPO::getGmtCreate, categoryDO.getGmtCreate());
            query.eq(Objects.nonNull(categoryDO.getCreateBy()), CategoryPO::getCreateBy, categoryDO.getCreateBy());
            query.eq(Objects.nonNull(categoryDO.getGmtModified()), CategoryPO::getGmtModified, categoryDO.getGmtModified());
            query.eq(Objects.nonNull(categoryDO.getUpdateBy()), CategoryPO::getUpdateBy, categoryDO.getUpdateBy());
            query.eq(Objects.nonNull(categoryDO.getShopId()), CategoryPO::getShopId, categoryDO.getShopId());
            query.eq(Objects.nonNull(categoryDO.getName()), CategoryPO::getName, categoryDO.getName());
        }
        return query;
    }
}

