package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.UserDO;
import com.shop.entity.UserPO;


@Mapper(componentModel = "spring")
public interface UserConverter extends CoreConverter<UserDO, UserPO> {

}

