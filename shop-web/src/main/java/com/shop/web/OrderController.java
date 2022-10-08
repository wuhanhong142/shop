package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.OrderDTO;
import com.shop.facade.OrderFacade;


@Slf4j
@RestController
@RequestMapping("order")
@AllArgsConstructor
public class OrderController extends BaseController<OrderDTO, OrderFacade> {
}

