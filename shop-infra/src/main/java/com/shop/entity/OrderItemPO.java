package com.shop.entity;

import java.util.Date;

import com.shop.core.model.BasePO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_order_item")
public class OrderItemPO extends BasePO {


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

