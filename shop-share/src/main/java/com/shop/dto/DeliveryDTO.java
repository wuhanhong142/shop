package com.shop.dto;

import java.util.Date;

import com.shop.core.model.BaseDTO;

import java.io.Serializable;

import lombok.Data;


@Data
public class DeliveryDTO extends BaseDTO implements Serializable {

    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 配送状态
     */
    private String deliveryStatus;
}

