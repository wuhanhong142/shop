package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.ImageDTO;
import com.shop.converter.ImageDTOConverter;
import com.shop.model.ImageDO;
import com.shop.service.ImageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ImageFacade extends FacadeImpl<ImageDTO, ImageDO, ImageDTOConverter, ImageService> {
}

