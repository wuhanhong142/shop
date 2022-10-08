package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.ShopUserDTO;
import com.shop.facade.ShopUserFacade;


@Slf4j
@RestController
@RequestMapping("shopUser")
@AllArgsConstructor
public class ShopUserController extends BaseController<ShopUserDTO, ShopUserFacade> {
}

