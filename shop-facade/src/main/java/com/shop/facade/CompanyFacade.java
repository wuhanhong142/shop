package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.CompanyDTO;
import com.shop.converter.CompanyDTOConverter;
import com.shop.model.CompanyDO;
import com.shop.service.CompanyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CompanyFacade extends FacadeImpl<CompanyDTO, CompanyDO, CompanyDTOConverter, CompanyService> {
}

