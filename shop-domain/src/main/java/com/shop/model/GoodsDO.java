package com.shop.model;

import java.util.Date;

import com.shop.core.model.BaseDO;

import java.io.Serializable;

import lombok.Data;

@Data
public class GoodsDO extends BaseDO {


    /**
     * 商品分类信息
     */
    private Long categoryId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 面价
     */
    private Double facePrice;

    /**
     * 售价
     */
    private Double salePrice;

    /**
     * 限购数量
     */
    private Integer limitNumber;

    /**
     * 起订量
     */
    private Integer moq;

    /**
     * 加量增幅
     */
    private Integer moqIncrease;

    /**
     * 商品说明
     */
    private String content;

    /**
     * 商品标签
     */
    private String tags;

    /**
     * 商品图片
     */
    private Long image;
}

