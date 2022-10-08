package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.ShopDTO;
import com.shop.converter.ShopDTOConverter;
import com.shop.model.ShopDO;
import com.shop.service.ShopService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ShopFacade extends FacadeImpl<ShopDTO, ShopDO, ShopDTOConverter, ShopService> {
}

