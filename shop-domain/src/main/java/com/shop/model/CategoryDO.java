package com.shop.model;

import java.util.Date;

import com.shop.core.model.BaseDO;

import java.io.Serializable;

import lombok.Data;

@Data
public class CategoryDO extends BaseDO {


    /**
     * 商家ID
     */
    private Long shopId;

    /**
     * 分类名称
     */
    private String name;
}

