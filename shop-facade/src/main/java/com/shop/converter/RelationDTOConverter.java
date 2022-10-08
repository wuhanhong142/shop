package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.RelationDO;
import com.shop.dto.RelationDTO;

@Mapper(componentModel = "spring")
public interface RelationDTOConverter extends CoreDTOConverter<RelationDTO, RelationDO> {

}

