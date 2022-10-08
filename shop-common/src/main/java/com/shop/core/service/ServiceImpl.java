package com.shop.core.service;


import com.shop.core.model.BaseDO;
import com.shop.core.repoistory.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceImpl<D extends BaseDO, R extends IRepository<D>> implements IService<D> {

    @Autowired
    protected R repository;

    public boolean update(D dataDo) {
        return repository.update(dataDo);
    }

    public boolean add(D dataDo) {
        return repository.add(dataDo);
    }

    @Override
    public Long addAndReturnId(D dataDo) {
        return repository.addAndReturnId(dataDo);
    }

    public D findById(Long id) {
        return repository.findById(id);
    }

    public boolean removeById(Long id) {
        return repository.removeById(id);
    }

    public List<D> findByModel(D dataDo, int start, Integer pageSize, String field, String direction) {
        return repository.findByModel(dataDo, start, pageSize, field, direction);
    }

    public long count(D dataDo) {
        return repository.count(dataDo);
    }

}
