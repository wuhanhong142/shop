package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.RoleDO;
import com.shop.dto.RoleDTO;

@Mapper(componentModel = "spring")
public interface RoleDTOConverter extends CoreDTOConverter<RoleDTO, RoleDO> {

}

