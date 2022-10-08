package com.shop.facade;

import com.shop.core.facade.FacadeImpl;
import com.shop.dto.GoodsDTO;
import com.shop.converter.GoodsDTOConverter;
import com.shop.model.GoodsDO;
import com.shop.service.GoodsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class GoodsFacade extends FacadeImpl<GoodsDTO, GoodsDO, GoodsDTOConverter, GoodsService> {
}

