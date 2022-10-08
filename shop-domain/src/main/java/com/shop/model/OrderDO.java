package com.shop.model;

import java.util.Date;

import com.shop.core.model.BaseDO;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrderDO extends BaseDO {


    /**
     * 订单归属商户
     */
    private Long shopId;

    /**
     * 订单归属用户
     */
    private Long userId;

    /**
     * 订单地址
     */
    private Long addressId;

    /**
     * 发票信息
     */
    private Long invoiceId;

    /**
     * 总金额
     */
    private Double amount;

    /**
     * 优惠金额
     */
    private Double discountAmount;

    /**
     * 运费金额
     */
    private Double deliveryAmount;

    /**
     * 总金额
     */
    private Double totalAmount;

    /**
     * 下单时间
     */
    private Date createTime;

    /**
     * 发货时间
     */
    private Date shippingTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 收货时间
     */
    private Date receiveTime;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 订单备注
     */
    private String remark;
}

