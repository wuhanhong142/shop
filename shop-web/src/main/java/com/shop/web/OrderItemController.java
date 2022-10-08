package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.OrderItemDTO;
import com.shop.facade.OrderItemFacade;


@Slf4j
@RestController
@RequestMapping("orderItem")
@AllArgsConstructor
public class OrderItemController extends BaseController<OrderItemDTO, OrderItemFacade> {
}

