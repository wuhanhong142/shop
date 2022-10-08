package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.ImageDO;
import com.shop.entity.ImagePO;


@Mapper(componentModel = "spring")
public interface ImageConverter extends CoreConverter<ImageDO, ImagePO> {

}

