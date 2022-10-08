package com.shop.model;

import java.util.Date;

import com.shop.core.model.BaseDO;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResourceDO extends BaseDO {


    /**
     * 父级
     */
    private Long parentId;

    /**
     * 路径
     */
    private String url;

    /**
     * 图标
     */
    private String icon;

    private String name;
}

