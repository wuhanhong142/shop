package com.shop.dto;

import java.util.Date;

import com.shop.core.model.BaseDTO;

import java.io.Serializable;

import lombok.Data;


@Data
public class CategoryDTO extends BaseDTO implements Serializable {

    /**
     * 商家ID
     */
    private Long shopId;
    /**
     * 分类名称
     */
    private String name;
}

