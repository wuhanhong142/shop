package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.RoleDTO;
import com.shop.converter.RoleDTOConverter;
import com.shop.model.RoleDO;
import com.shop.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class RoleFacade extends FacadeImpl<RoleDTO, RoleDO, RoleDTOConverter, RoleService> {
}

