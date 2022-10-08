package com.shop.web;


import com.shop.core.controller.BaseController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.ImageDTO;
import com.shop.facade.ImageFacade;


@Slf4j
@RestController
@RequestMapping("image")
@AllArgsConstructor
public class ImageController extends BaseController<ImageDTO, ImageFacade> {
}

