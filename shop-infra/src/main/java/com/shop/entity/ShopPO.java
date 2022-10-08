package com.shop.entity;

import java.util.Date;

import com.shop.core.model.BasePO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_shop")
public class ShopPO extends BasePO {


    /**
     * 商家名称
     */
    private String name;

    /**
     * 起送金额
     */
    private Double moqAmount;

    /**
     * 配送费
     */
    private Double freight;

    /**
     * 商家地址
     */
    private Long address;

    /**
     * 商家电话
     */
    private String phone;

    /**
     * 营业时间起
     */
    private String tradeStart;

    /**
     * 营业时间止
     */
    private String tradeEnd;
}

