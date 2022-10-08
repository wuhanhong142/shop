package com.shop.entity;

import java.util.Date;

import com.shop.core.model.BasePO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class UserPO extends BasePO {


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

