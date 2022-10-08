package com.shop.entity;

import java.util.Date;

import com.shop.core.model.BasePO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_address")
public class AddressPO extends BasePO {


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

