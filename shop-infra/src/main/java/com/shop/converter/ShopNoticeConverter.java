package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.ShopNoticeDO;
import com.shop.entity.ShopNoticePO;


@Mapper(componentModel = "spring")
public interface ShopNoticeConverter extends CoreConverter<ShopNoticeDO, ShopNoticePO> {

}

