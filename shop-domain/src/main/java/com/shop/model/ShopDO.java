package com.shop.model;

import java.util.Date;

import com.shop.core.model.BaseDO;

import java.io.Serializable;

import lombok.Data;

@Data
public class ShopDO extends BaseDO {


    /**
     * 商家名称
     */
    private String name;

    /**
     * 起送金额
     */
    private Double moqAmount;

    /**
     * 配送费
     */
    private Double freight;

    /**
     * 商家地址
     */
    private Long address;

    /**
     * 商家电话
     */
    private String phone;

    /**
     * 营业时间起
     */
    private String tradeStart;

    /**
     * 营业时间止
     */
    private String tradeEnd;
}

