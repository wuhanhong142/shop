package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.RoleDTO;
import com.shop.facade.RoleFacade;


@Slf4j
@RestController
@RequestMapping("role")
@AllArgsConstructor
public class RoleController extends BaseController<RoleDTO, RoleFacade> {
}

