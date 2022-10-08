package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.CategoryDTO;
import com.shop.converter.CategoryDTOConverter;
import com.shop.model.CategoryDO;
import com.shop.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryFacade extends FacadeImpl<CategoryDTO, CategoryDO, CategoryDTOConverter, CategoryService> {
}

