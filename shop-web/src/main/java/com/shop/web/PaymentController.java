package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.PaymentDTO;
import com.shop.facade.PaymentFacade;


@Slf4j
@RestController
@RequestMapping("payment")
@AllArgsConstructor
public class PaymentController extends BaseController<PaymentDTO, PaymentFacade> {
}

