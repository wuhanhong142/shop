package com.shop.dto;

import java.util.Date;

import com.shop.core.model.BaseDTO;

import java.io.Serializable;

import lombok.Data;


@Data
public class OrderItemDTO extends BaseDTO implements Serializable {

    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 订单商品ID
     */
    private Long goodId;
    /**
     * 商品名称
     */
    private String goodName;
    /**
     * 购买商品数量
     */
    private Integer goodCnt;
    /**
     * 购买商品单价
     */
    private Double goodPrice;
    /**
     * 优惠分摊金额
     */
    private Double feeMoney;
}

