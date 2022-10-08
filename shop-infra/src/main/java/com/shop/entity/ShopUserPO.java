package com.shop.entity;

import java.util.Date;

import com.shop.core.model.BasePO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_shop_user")
public class ShopUserPO extends BasePO {


    /**
     * 归属商家
     */
    private Long shopId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String loginMobile;

    /**
     * 密码
     */
    private String password;
}

