package com.shop.entity;

import com.shop.core.model.BasePO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_shop_notice")
public class ShopNoticePO extends BasePO {


    /**
     * 商家ID
     */
    private Long shopId;

    /**
     * 公告
     */
    private String content;
}

