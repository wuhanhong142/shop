package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.ShopUserDO;
import com.shop.entity.ShopUserPO;


@Mapper(componentModel = "spring")
public interface ShopUserConverter extends CoreConverter<ShopUserDO, ShopUserPO> {

}

