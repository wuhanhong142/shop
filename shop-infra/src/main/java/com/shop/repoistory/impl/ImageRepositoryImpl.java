package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.ImageConverter;
import com.shop.model.ImageDO;
import com.shop.entity.ImagePO;
import com.shop.mapper.ImageMapper;
import com.shop.repoistory.ImageRepository;


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
public class ImageRepositoryImpl extends RepositoryImpl<ImageMapper, ImagePO, ImageConverter, ImageDO> implements ImageRepository {


    @Override
    public List<ImageDO> findByModel(ImageDO imageDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<ImagePO> wapper = wapper(imageDO);
        wapper.last(lastSql);

        List<ImagePO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(ImageDO imageDO) {
        return wapper(imageDO).count();
    }

    private LambdaQueryChainWrapper<ImagePO> wapper(ImageDO imageDO) {
        LambdaQueryChainWrapper<ImagePO> query = lambdaQuery();
        if (imageDO != null) {
            query.eq(Objects.nonNull(imageDO.getGmtCreate()), ImagePO::getGmtCreate, imageDO.getGmtCreate());
            query.eq(Objects.nonNull(imageDO.getCreateBy()), ImagePO::getCreateBy, imageDO.getCreateBy());
            query.eq(Objects.nonNull(imageDO.getGmtModified()), ImagePO::getGmtModified, imageDO.getGmtModified());
            query.eq(Objects.nonNull(imageDO.getUpdateBy()), ImagePO::getUpdateBy, imageDO.getUpdateBy());
            query.eq(Objects.nonNull(imageDO.getBusinessId()), ImagePO::getBusinessId, imageDO.getBusinessId());
            query.eq(Objects.nonNull(imageDO.getImageType()), ImagePO::getImageType, imageDO.getImageType());
            query.eq(Objects.nonNull(imageDO.getThumbnailUrl()), ImagePO::getThumbnailUrl, imageDO.getThumbnailUrl());
            query.eq(Objects.nonNull(imageDO.getImageUrl()), ImagePO::getImageUrl, imageDO.getImageUrl());
        }
        return query;
    }
}

