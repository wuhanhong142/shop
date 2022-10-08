package com.shop.dto;

import com.shop.core.model.BaseDTO;

import java.io.Serializable;

import lombok.Data;


@Data
public class ShopNoticeDTO extends BaseDTO implements Serializable {

    /**
     * 商家ID
     */
    private Long shopId;
    /**
     * 公告
     */
    private String content;
}

