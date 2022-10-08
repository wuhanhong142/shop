package com.shop.dto;

import java.util.Date;

import com.shop.core.model.BaseDTO;

import java.io.Serializable;

import lombok.Data;


@Data
public class PaymentDTO extends BaseDTO implements Serializable {

    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 支付金额
     */
    private Double amount;
    /**
     * 支付渠道
     */
    private String channel;
    /**
     * 支付状态
     */
    private String payStatus;
    /**
     * 支付备注
     */
    private String remark;
}

