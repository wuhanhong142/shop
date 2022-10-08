package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.UserDO;
import com.shop.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserDTOConverter extends CoreDTOConverter<UserDTO, UserDO> {

}

