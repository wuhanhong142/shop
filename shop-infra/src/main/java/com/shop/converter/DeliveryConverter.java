package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.DeliveryDO;
import com.shop.entity.DeliveryPO;


@Mapper(componentModel = "spring")
public interface DeliveryConverter extends CoreConverter<DeliveryDO, DeliveryPO> {

}

