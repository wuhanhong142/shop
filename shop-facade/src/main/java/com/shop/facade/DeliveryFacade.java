package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.DeliveryDTO;
import com.shop.converter.DeliveryDTOConverter;
import com.shop.model.DeliveryDO;
import com.shop.service.DeliveryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class DeliveryFacade extends FacadeImpl<DeliveryDTO, DeliveryDO, DeliveryDTOConverter, DeliveryService> {
}

