package com.shop.entity;

import java.util.Date;

import com.shop.core.model.BasePO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_payment")
public class PaymentPO extends BasePO {


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

