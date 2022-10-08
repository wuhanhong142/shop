package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.ResourceDO;
import com.shop.dto.ResourceDTO;

@Mapper(componentModel = "spring")
public interface ResourceDTOConverter extends CoreDTOConverter<ResourceDTO, ResourceDO> {

}

