package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.ResourceDTO;
import com.shop.converter.ResourceDTOConverter;
import com.shop.model.ResourceDO;
import com.shop.service.ResourceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ResourceFacade extends FacadeImpl<ResourceDTO, ResourceDO, ResourceDTOConverter, ResourceService> {
}

