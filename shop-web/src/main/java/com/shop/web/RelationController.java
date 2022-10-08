package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.RelationDTO;
import com.shop.facade.RelationFacade;


@Slf4j
@RestController
@RequestMapping("relation")
@AllArgsConstructor
public class RelationController extends BaseController<RelationDTO, RelationFacade> {
}

