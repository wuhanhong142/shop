package com.shop.core.repoistory;


import com.shop.core.model.BaseDO;

import java.util.List;

public interface IRepository<D extends BaseDO> {
    boolean update(D dataDo);

    boolean add(D dataDo);

    Long addAndReturnId(D dataDo);

    D findById(Long id);

    boolean removeById(Long id);

    List<D> findByModel(D dataDo, int start, Integer pageSize, String field, String direction);

    long count(D dataDo);
}
