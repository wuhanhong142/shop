package com.shop.service;


import com.shop.core.service.ServiceImpl;
import com.shop.model.AddressDO;
import com.shop.repoistory.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AddressService extends ServiceImpl<AddressDO, AddressRepository> {

}
