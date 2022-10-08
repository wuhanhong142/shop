package com.shop.model;

import java.util.Date;

import com.shop.core.model.BaseDO;

import java.io.Serializable;

import lombok.Data;

@Data
public class CompanyDO extends BaseDO {


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

