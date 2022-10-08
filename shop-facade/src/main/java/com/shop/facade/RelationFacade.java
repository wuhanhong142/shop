package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.RelationDTO;
import com.shop.converter.RelationDTOConverter;
import com.shop.model.RelationDO;
import com.shop.service.RelationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class RelationFacade extends FacadeImpl<RelationDTO, RelationDO, RelationDTOConverter, RelationService> {
}

