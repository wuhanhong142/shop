package com.shop.service;


import com.shop.core.service.ServiceImpl;
import com.shop.model.PaymentDO;
import com.shop.repoistory.PaymentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PaymentService extends ServiceImpl<PaymentDO, PaymentRepository> {

}
