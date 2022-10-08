package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.ShopNoticeDTO;
import com.shop.facade.ShopNoticeFacade;


@Slf4j
@RestController
@RequestMapping("shopNotice")
@AllArgsConstructor
public class ShopNoticeController extends BaseController<ShopNoticeDTO, ShopNoticeFacade> {
}

