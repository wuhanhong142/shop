package com.shop.service;


import com.shop.core.service.ServiceImpl;
import com.shop.model.CompanyDO;
import com.shop.repoistory.CompanyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CompanyService extends ServiceImpl<CompanyDO, CompanyRepository> {

}
