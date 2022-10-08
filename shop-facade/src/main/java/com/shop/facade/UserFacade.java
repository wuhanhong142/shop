package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.UserDTO;
import com.shop.converter.UserDTOConverter;
import com.shop.model.UserDO;
import com.shop.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class UserFacade extends FacadeImpl<UserDTO, UserDO, UserDTOConverter, UserService> {
}

