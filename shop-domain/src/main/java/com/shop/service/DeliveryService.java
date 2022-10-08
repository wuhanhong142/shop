package com.shop.service;


import com.shop.core.service.ServiceImpl;
import com.shop.model.DeliveryDO;
import com.shop.repoistory.DeliveryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DeliveryService extends ServiceImpl<DeliveryDO, DeliveryRepository> {

}
