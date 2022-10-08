package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.ShopDTO;
import com.shop.facade.ShopFacade;


@Slf4j
@RestController
@RequestMapping("shop")
@AllArgsConstructor
public class ShopController extends BaseController<ShopDTO, ShopFacade> {
}

