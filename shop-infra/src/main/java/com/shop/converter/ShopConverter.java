package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.ShopDO;
import com.shop.entity.ShopPO;


@Mapper(componentModel = "spring")
public interface ShopConverter extends CoreConverter<ShopDO, ShopPO> {

}

