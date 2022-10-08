package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.OrderDO;
import com.shop.entity.OrderPO;


@Mapper(componentModel = "spring")
public interface OrderConverter extends CoreConverter<OrderDO, OrderPO> {

}

