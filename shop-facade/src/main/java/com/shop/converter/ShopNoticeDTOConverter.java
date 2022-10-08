package com.shop.converter;

import com.shop.core.converter.CoreDTOConverter;
import org.mapstruct.Mapper;
import com.shop.model.ShopNoticeDO;
import com.shop.dto.ShopNoticeDTO;

@Mapper(componentModel = "spring")
public interface ShopNoticeDTOConverter extends CoreDTOConverter<ShopNoticeDTO, ShopNoticeDO> {

}

