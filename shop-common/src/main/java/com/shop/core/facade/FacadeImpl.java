package com.shop.core.facade;


import com.shop.core.converter.CoreDTOConverter;
import com.shop.core.model.BaseDO;
import com.shop.core.model.BaseDTO;
import com.shop.core.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class FacadeImpl<DTO extends BaseDTO, D extends BaseDO, C extends CoreDTOConverter<DTO, D>, S extends IService<D>> implements IFacade<DTO> {
    @Autowired
    protected C converter;
    @Autowired
    protected S service;

    public boolean add(DTO dto) {
        return service.add(converter.dto2Model(dto));
    }

    public boolean update(DTO dto) {
        return service.update(converter.dto2Model(dto));
    }

    public DTO queryOne(Long id) {
        return converter.model2Dto(service.findById(id));
    }

    public boolean remove(Long id) {
        return service.removeById(id);
    }

    public List<DTO> queryList(DTO dto, int start, Integer pageSize, String field, String direction) {
        D d = converter.dto2Model(dto);
        List<D> list = service.findByModel(d, start, pageSize, field, direction);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.stream().map(converter::model2Dto).collect(Collectors.toList());
    }

    public long count(DTO dto) {
        return service.count(converter.dto2Model(dto));
    }
}
