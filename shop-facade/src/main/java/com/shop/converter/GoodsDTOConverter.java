package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.GoodsDO;
import com.shop.dto.GoodsDTO;

@Mapper(componentModel = "spring")
public interface GoodsDTOConverter extends CoreDTOConverter<GoodsDTO, GoodsDO> {

}

