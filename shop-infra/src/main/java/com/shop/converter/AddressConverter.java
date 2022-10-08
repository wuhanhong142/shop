package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.AddressDO;
import com.shop.entity.AddressPO;


@Mapper(componentModel = "spring")
public interface AddressConverter extends CoreConverter<AddressDO, AddressPO> {

}

