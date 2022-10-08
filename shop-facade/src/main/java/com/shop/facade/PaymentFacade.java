package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.PaymentDTO;
import com.shop.converter.PaymentDTOConverter;
import com.shop.model.PaymentDO;
import com.shop.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class PaymentFacade extends FacadeImpl<PaymentDTO, PaymentDO, PaymentDTOConverter, PaymentService> {
}

