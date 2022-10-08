package com.shop.repoistory.impl;

import com.shop.core.repoistory.RepositoryImpl;
import com.shop.converter.GoodsConverter;
import com.shop.model.GoodsDO;
import com.shop.entity.GoodsPO;
import com.shop.mapper.GoodsMapper;
import com.shop.repoistory.GoodsRepository;


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
public class GoodsRepositoryImpl extends RepositoryImpl<GoodsMapper, GoodsPO, GoodsConverter, GoodsDO> implements GoodsRepository {


    @Override
    public List<GoodsDO> findByModel(GoodsDO goodsDO, int start, Integer pageSize, String field, String direction) {
        String lastSql = StringUtils.hasText(field) ? " order by " + field + direction + " limit " + start + "," + pageSize : " limit " + start + "," + pageSize;

        LambdaQueryChainWrapper<GoodsPO> wapper = wapper(goodsDO);
        wapper.last(lastSql);

        List<GoodsPO> list = wapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::po2Model).collect(Collectors.toList());
    }

    @Override
    public long count(GoodsDO goodsDO) {
        return wapper(goodsDO).count();
    }

    private LambdaQueryChainWrapper<GoodsPO> wapper(GoodsDO goodsDO) {
        LambdaQueryChainWrapper<GoodsPO> query = lambdaQuery();
        if (goodsDO != null) {
            query.eq(Objects.nonNull(goodsDO.getGmtCreate()), GoodsPO::getGmtCreate, goodsDO.getGmtCreate());
            query.eq(Objects.nonNull(goodsDO.getCreateBy()), GoodsPO::getCreateBy, goodsDO.getCreateBy());
            query.eq(Objects.nonNull(goodsDO.getGmtModified()), GoodsPO::getGmtModified, goodsDO.getGmtModified());
            query.eq(Objects.nonNull(goodsDO.getUpdateBy()), GoodsPO::getUpdateBy, goodsDO.getUpdateBy());
            query.eq(Objects.nonNull(goodsDO.getCategoryId()), GoodsPO::getCategoryId, goodsDO.getCategoryId());
            query.eq(Objects.nonNull(goodsDO.getName()), GoodsPO::getName, goodsDO.getName());
            query.eq(Objects.nonNull(goodsDO.getStock()), GoodsPO::getStock, goodsDO.getStock());
            query.eq(Objects.nonNull(goodsDO.getFacePrice()), GoodsPO::getFacePrice, goodsDO.getFacePrice());
            query.eq(Objects.nonNull(goodsDO.getSalePrice()), GoodsPO::getSalePrice, goodsDO.getSalePrice());
            query.eq(Objects.nonNull(goodsDO.getLimitNumber()), GoodsPO::getLimitNumber, goodsDO.getLimitNumber());
            query.eq(Objects.nonNull(goodsDO.getMoq()), GoodsPO::getMoq, goodsDO.getMoq());
            query.eq(Objects.nonNull(goodsDO.getMoqIncrease()), GoodsPO::getMoqIncrease, goodsDO.getMoqIncrease());
            query.eq(Objects.nonNull(goodsDO.getContent()), GoodsPO::getContent, goodsDO.getContent());
            query.eq(Objects.nonNull(goodsDO.getTags()), GoodsPO::getTags, goodsDO.getTags());
            query.eq(Objects.nonNull(goodsDO.getImage()), GoodsPO::getImage, goodsDO.getImage());
        }
        return query;
    }
}

