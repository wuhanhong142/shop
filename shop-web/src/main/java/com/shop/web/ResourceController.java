package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.ResourceDTO;
import com.shop.facade.ResourceFacade;


@Slf4j
@RestController
@RequestMapping("resource")
@AllArgsConstructor
public class ResourceController extends BaseController<ResourceDTO, ResourceFacade> {
}

