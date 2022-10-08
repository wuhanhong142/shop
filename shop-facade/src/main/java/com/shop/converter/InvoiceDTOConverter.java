package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.InvoiceDO;
import com.shop.dto.InvoiceDTO;

@Mapper(componentModel = "spring")
public interface InvoiceDTOConverter extends CoreDTOConverter<InvoiceDTO, InvoiceDO> {

}

