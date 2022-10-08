package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.RelationDO;
import com.shop.entity.RelationPO;


@Mapper(componentModel = "spring")
public interface RelationConverter extends CoreConverter<RelationDO, RelationPO> {

}

