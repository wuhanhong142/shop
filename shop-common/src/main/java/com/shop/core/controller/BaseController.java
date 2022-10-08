package com.shop.core.controller;


import com.shop.core.facade.IFacade;
import com.shop.core.model.BaseDTO;
import com.shop.page.PageInfoDTO;
import com.shop.page.PageQueryDTO;
import com.shop.page.SortedParamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public class BaseController<DTO extends BaseDTO, F extends IFacade<DTO>> {
    
    @Autowired
    protected  F facade;

    @PostMapping("save")
    public Boolean save(@Valid @RequestBody DTO dto) {
        return facade.add(dto);
    }

    @PostMapping("update")
    public Boolean update(@Valid @RequestBody DTO dto) {
        return facade.update(dto);
    }

    @GetMapping("find/{id}")
    public DTO queryOne(@PathVariable("id") Long id) {
        return facade.queryOne(id);
    }

    @PostMapping("remove/{id}")
    public Boolean remove(@PathVariable("id") Long id) {
        return facade.remove(id);
    }

    @PostMapping("findByPage")
    public PageInfoDTO<DTO> findByPage(@RequestBody PageQueryDTO<DTO> queryDTO) {

        SortedParamDTO sortedParamDTO = queryDTO.getSortParam();
        List<DTO> list = facade.queryList(queryDTO.getParam(), queryDTO.getStart(), queryDTO.getPageSize(),
                sortedParamDTO.getField(), sortedParamDTO.getDirection());

        if (CollectionUtils.isEmpty(list)) {
            return new PageInfoDTO<DTO>(queryDTO.getPageNo(), queryDTO.getPageSize(), 0, null);
        }

        long total = queryDTO.getTotal();
        if (queryDTO.isNotNeedPageQuery()) {
            total = facade.count(queryDTO.getParam());
        }

        return new PageInfoDTO<DTO>(queryDTO.getPageNo(), queryDTO.getPageSize(), total, list);
    }
}
