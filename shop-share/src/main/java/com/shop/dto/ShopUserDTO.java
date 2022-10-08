package com.shop.dto;

import java.util.Date;

import com.shop.core.model.BaseDTO;

import java.io.Serializable;

import lombok.Data;


@Data
public class ShopUserDTO extends BaseDTO implements Serializable {

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

