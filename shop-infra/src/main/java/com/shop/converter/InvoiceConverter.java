package com.shop.converter;

import com.shop.core.converter.CoreConverter;
import org.mapstruct.Mapper;
import com.shop.model.InvoiceDO;
import com.shop.entity.InvoicePO;


@Mapper(componentModel = "spring")
public interface InvoiceConverter extends CoreConverter<InvoiceDO, InvoicePO> {

}

