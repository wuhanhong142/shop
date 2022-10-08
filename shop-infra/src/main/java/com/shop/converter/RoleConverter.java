package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.RoleDO;
import com.shop.entity.RolePO;


@Mapper(componentModel = "spring")
public interface RoleConverter extends CoreConverter<RoleDO, RolePO> {

}

