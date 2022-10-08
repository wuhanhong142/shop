package com.shop.core.converter;


import com.shop.core.model.BaseDO;
import com.shop.core.model.BaseDTO;

public interface CoreDTOConverter<DTO extends BaseDTO, D extends BaseDO> {
    /**
     * 领域对象转DTO
     */
    DTO model2Dto(D model);

    /**
     * DTO转领域对象
     */
    D dto2Model(DTO dto);
}
