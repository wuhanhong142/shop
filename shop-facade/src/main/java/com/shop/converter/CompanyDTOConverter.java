package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.CompanyDO;
import com.shop.dto.CompanyDTO;

@Mapper(componentModel = "spring")
public interface CompanyDTOConverter extends CoreDTOConverter<CompanyDTO, CompanyDO> {

}

