package com.shop.model;

import java.util.Date;

import com.shop.core.model.BaseDO;

import java.io.Serializable;

import lombok.Data;

@Data
public class DeliveryDO extends BaseDO {


    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 配送状态
     */
    private String deliveryStatus;
}

