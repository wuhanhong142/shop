package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.PaymentDO;
import com.shop.entity.PaymentPO;


@Mapper(componentModel = "spring")
public interface PaymentConverter extends CoreConverter<PaymentDO, PaymentPO> {

}

