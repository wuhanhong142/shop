package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.OrderItemDO;
import com.shop.entity.OrderItemPO;


@Mapper(componentModel = "spring")
public interface OrderItemConverter extends CoreConverter<OrderItemDO, OrderItemPO> {

}

