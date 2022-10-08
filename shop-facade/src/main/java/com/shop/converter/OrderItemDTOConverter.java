package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.OrderItemDO;
import com.shop.dto.OrderItemDTO;

@Mapper(componentModel = "spring")
public interface OrderItemDTOConverter extends CoreDTOConverter<OrderItemDTO, OrderItemDO> {

}

