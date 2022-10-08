package com.shop.entity;

import java.util.Date;

import com.shop.core.model.BasePO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_company")
public class CompanyPO extends BasePO {


    /**
     * 企业名称
     */
    private String name;

    /**
     * 统一社会信用代码
     */
    private String socialCode;

    /**
     * 法定代表人
     */
    private String legalName;

    /**
     * 成立日期
     */
    private String establishDate;
}

