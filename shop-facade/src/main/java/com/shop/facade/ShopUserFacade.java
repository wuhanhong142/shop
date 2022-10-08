package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.ShopUserDTO;
import com.shop.converter.ShopUserDTOConverter;
import com.shop.model.ShopUserDO;
import com.shop.service.ShopUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ShopUserFacade extends FacadeImpl<ShopUserDTO, ShopUserDO, ShopUserDTOConverter, ShopUserService> {
}

