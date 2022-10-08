package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.AddressDTO;
import com.shop.facade.AddressFacade;


@Slf4j
@RestController
@RequestMapping("address")
@AllArgsConstructor
public class AddressController extends BaseController<AddressDTO, AddressFacade> {
}

