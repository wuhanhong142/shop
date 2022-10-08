package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.GoodsDO;
import com.shop.entity.GoodsPO;


@Mapper(componentModel = "spring")
public interface GoodsConverter extends CoreConverter<GoodsDO, GoodsPO> {

}

