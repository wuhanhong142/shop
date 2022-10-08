package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.CategoryDO;
import com.shop.dto.CategoryDTO;

@Mapper(componentModel = "spring")
public interface CategoryDTOConverter extends CoreDTOConverter<CategoryDTO, CategoryDO> {

}

