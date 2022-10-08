package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.AddressDO;
import com.shop.dto.AddressDTO;

@Mapper(componentModel = "spring")
public interface AddressDTOConverter extends CoreDTOConverter<AddressDTO, AddressDO> {

}

