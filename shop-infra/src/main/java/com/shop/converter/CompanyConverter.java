package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.CompanyDO;
import com.shop.entity.CompanyPO;


@Mapper(componentModel = "spring")
public interface CompanyConverter extends CoreConverter<CompanyDO, CompanyPO> {

}

