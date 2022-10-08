package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.InvoiceDTO;
import com.shop.converter.InvoiceDTOConverter;
import com.shop.model.InvoiceDO;
import com.shop.service.InvoiceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class InvoiceFacade extends FacadeImpl<InvoiceDTO, InvoiceDO, InvoiceDTOConverter, InvoiceService> {
}

