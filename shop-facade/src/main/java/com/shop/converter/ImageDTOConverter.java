package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.ImageDO;
import com.shop.dto.ImageDTO;

@Mapper(componentModel = "spring")
public interface ImageDTOConverter extends CoreDTOConverter<ImageDTO, ImageDO> {

}

