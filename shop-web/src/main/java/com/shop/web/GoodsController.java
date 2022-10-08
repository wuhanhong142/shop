package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.GoodsDTO;
import com.shop.facade.GoodsFacade;


@Slf4j
@RestController
@RequestMapping("goods")
@AllArgsConstructor
public class GoodsController extends BaseController<GoodsDTO, GoodsFacade> {
}

