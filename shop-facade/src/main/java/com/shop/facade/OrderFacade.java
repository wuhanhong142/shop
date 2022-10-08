package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.OrderDTO;
import com.shop.converter.OrderDTOConverter;
import com.shop.model.OrderDO;
import com.shop.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class OrderFacade extends FacadeImpl<OrderDTO, OrderDO, OrderDTOConverter, OrderService> {
}

