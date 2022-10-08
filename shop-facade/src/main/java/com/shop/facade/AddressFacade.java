package com.shop.facade;

import com.shop.converter.AddressDTOConverter;
import com.shop.core.facade.FacadeImpl;
import com.shop.dto.AddressDTO;
import com.shop.model.AddressDO;
import com.shop.service.AddressService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AddressFacade extends FacadeImpl<AddressDTO, AddressDO, AddressDTOConverter, AddressService> {
}

