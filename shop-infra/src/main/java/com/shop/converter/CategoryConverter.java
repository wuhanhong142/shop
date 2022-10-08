package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.CategoryDO;
import com.shop.entity.CategoryPO;


@Mapper(componentModel = "spring")
public interface CategoryConverter extends CoreConverter<CategoryDO, CategoryPO> {

}

