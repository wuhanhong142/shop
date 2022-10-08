package com.shop.model;

import java.util.Date;

import com.shop.core.model.BaseDO;

import java.io.Serializable;

import lombok.Data;

@Data
public class AddressDO extends BaseDO {


    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 乡镇
     */
    private String town;

    /**
     * 详细地址
     */
    private String detail;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 收件人
     */
    private String consignee;
}

