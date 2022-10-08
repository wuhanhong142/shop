package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.OrderItemDTO;
import com.shop.converter.OrderItemDTOConverter;
import com.shop.model.OrderItemDO;
import com.shop.service.OrderItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class OrderItemFacade extends FacadeImpl<OrderItemDTO, OrderItemDO, OrderItemDTOConverter, OrderItemService> {
}

