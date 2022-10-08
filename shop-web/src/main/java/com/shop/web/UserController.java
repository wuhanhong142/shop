package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.UserDTO;
import com.shop.facade.UserFacade;


@Slf4j
@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController extends BaseController<UserDTO, UserFacade> {
}

