package com.shop.service;


import com.shop.core.service.ServiceImpl;
import com.shop.model.ShopDO;
import com.shop.repoistory.ShopRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ShopService extends ServiceImpl<ShopDO, ShopRepository> {

}
