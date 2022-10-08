package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.CompanyDTO;
import com.shop.facade.CompanyFacade;


@Slf4j
@RestController
@RequestMapping("company")
@AllArgsConstructor
public class CompanyController extends BaseController<CompanyDTO, CompanyFacade> {
}

