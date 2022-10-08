package com.shop.model;

import com.shop.core.model.BaseDO;

import java.io.Serializable;

import lombok.Data;

@Data
public class ShopNoticeDO extends BaseDO {


    /**
     * 商家ID
     */
    private Long shopId;

    /**
     * 公告
     */
    private String content;
}

