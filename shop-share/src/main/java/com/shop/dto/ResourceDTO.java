package com.shop.dto;

import java.util.Date;

import com.shop.core.model.BaseDTO;

import java.io.Serializable;

import lombok.Data;


@Data
public class ResourceDTO extends BaseDTO implements Serializable {

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
}

