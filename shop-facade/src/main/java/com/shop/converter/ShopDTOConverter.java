package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.ShopDO;
import com.shop.dto.ShopDTO;

@Mapper(componentModel = "spring")
public interface ShopDTOConverter extends CoreDTOConverter<ShopDTO, ShopDO> {

}

