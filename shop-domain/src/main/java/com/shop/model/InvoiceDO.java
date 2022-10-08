package com.shop.model;

import java.util.Date;

import com.shop.core.model.BaseDO;

import java.io.Serializable;

import lombok.Data;

@Data
public class InvoiceDO extends BaseDO {


    /**
     * 是否增值税发票
     */
    private Integer isVat;

    /**
     * 发票抬头
     */
    private String title;

    /**
     * 发票内容
     */
    private String content;

    /**
     * 发票金额
     */
    private Double amount;

    /**
     * 发票税号
     */
    private String taxNo;

    /**
     * 开票税金
     */
    private String tax;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司地址
     */
    private String companyAddress;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 开户银行
     */
    private String bankName;

    /**
     * 银行帐号
     */
    private String bankAccount;
}

