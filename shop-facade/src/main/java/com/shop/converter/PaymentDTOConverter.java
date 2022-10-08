package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.PaymentDO;
import com.shop.dto.PaymentDTO;

@Mapper(componentModel = "spring")
public interface PaymentDTOConverter extends CoreDTOConverter<PaymentDTO, PaymentDO> {

}

