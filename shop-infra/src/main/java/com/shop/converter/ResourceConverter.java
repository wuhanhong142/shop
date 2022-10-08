package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.ResourceDO;
import com.shop.entity.ResourcePO;


@Mapper(componentModel = "spring")
public interface ResourceConverter extends CoreConverter<ResourceDO, ResourcePO> {

}

