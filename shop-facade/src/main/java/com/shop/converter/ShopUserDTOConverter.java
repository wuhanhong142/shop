package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.ShopUserDO;
import com.shop.dto.ShopUserDTO;

@Mapper(componentModel = "spring")
public interface ShopUserDTOConverter extends CoreDTOConverter<ShopUserDTO, ShopUserDO> {

}

