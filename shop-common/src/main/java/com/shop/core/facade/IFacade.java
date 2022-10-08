package com.shop.core.facade;

import com.shop.core.model.BaseDTO;

import java.util.List;

public interface IFacade<DTO extends BaseDTO> {

    boolean add(DTO dto);

    boolean update(DTO dto);

    DTO queryOne(Long id);

    boolean remove(Long id);

    List<DTO> queryList(DTO dto, int start, Integer pageSize, String field, String direction);

    long count(DTO dto);
}
