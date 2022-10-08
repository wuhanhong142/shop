package com.shop.model;

import java.util.Date;

import com.shop.core.model.BaseDO;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDO extends BaseDO {


    /**
     * 用户归属企业
     */
    private Long companyId;

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

