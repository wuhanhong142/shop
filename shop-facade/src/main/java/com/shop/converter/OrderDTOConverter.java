package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.OrderDO;
import com.shop.dto.OrderDTO;

@Mapper(componentModel = "spring")
public interface OrderDTOConverter extends CoreDTOConverter<OrderDTO, OrderDO> {

}

