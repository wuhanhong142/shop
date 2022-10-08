package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.CategoryDTO;
import com.shop.facade.CategoryFacade;


@Slf4j
@RestController
@RequestMapping("category")
@AllArgsConstructor
public class CategoryController extends BaseController<CategoryDTO, CategoryFacade> {
}

