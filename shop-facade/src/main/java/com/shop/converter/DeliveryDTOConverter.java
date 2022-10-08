package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.DeliveryDO;
import com.shop.dto.DeliveryDTO;

@Mapper(componentModel = "spring")
public interface DeliveryDTOConverter extends CoreDTOConverter<DeliveryDTO, DeliveryDO> {

}

