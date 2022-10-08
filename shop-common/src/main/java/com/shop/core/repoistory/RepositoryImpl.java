package com.shop.core.repoistory;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.core.converter.CoreConverter;
import com.shop.core.model.BaseDO;
import com.shop.core.model.BasePO;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class RepositoryImpl<
        M extends BaseMapper<T>,  //mybatis mapper处理类
        T extends BasePO, //db实体类
        C extends CoreConverter<D, T>, //实体与模型转换类
        D extends BaseDO //模型类
        >
        extends ServiceImpl<M, T> implements IRepository<D> {

    @Autowired
    protected C converter;

    @Override
    public boolean update(D dataDo) {
        T po = converter.model2Po(dataDo);
        return updateById(po);
    }

    @Override
    public boolean add(D dataDo) {
        T po = converter.model2Po(dataDo);
        return save(po);
    }

    @Override
    public Long addAndReturnId(D dataDo) {
        T po = converter.model2Po(dataDo);
        save(po);
        return po.getId();
    }

    @Override
    public D findById(Long id) {
        return converter.po2Model(baseMapper.selectById(id));
    }

    @Override
    public boolean removeById(Long id) {
        return baseMapper.deleteById(id) > 0;
    }
}
