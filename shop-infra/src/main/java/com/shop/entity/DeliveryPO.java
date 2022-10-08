package com.shop.entity;

import java.util.Date;

import com.shop.core.model.BasePO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_delivery")
public class DeliveryPO extends BasePO {


    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 配送状态
     */
    private String deliveryStatus;
}

