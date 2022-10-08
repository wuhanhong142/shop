package com.shop.core.converter;


import com.shop.core.model.BaseDO;
import com.shop.core.model.BasePO;

public interface CoreConverter<D extends BaseDO, P extends BasePO> {
    /**
     * 领域对象转数据库对象
     */
    P model2Po(D model);

    /**
     * 数据库对象转领域对象
     */
    D po2Model(P po);
}
