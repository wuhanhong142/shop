package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.ShopNoticeDTO;
import com.shop.converter.ShopNoticeDTOConverter;
import com.shop.model.ShopNoticeDO;
import com.shop.service.ShopNoticeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ShopNoticeFacade extends FacadeImpl<ShopNoticeDTO, ShopNoticeDO, ShopNoticeDTOConverter, ShopNoticeService> {
}

