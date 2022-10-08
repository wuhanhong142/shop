package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.InvoiceDTO;
import com.shop.facade.InvoiceFacade;


@Slf4j
@RestController
@RequestMapping("invoice")
@AllArgsConstructor
public class InvoiceController extends BaseController<InvoiceDTO, InvoiceFacade> {
}

