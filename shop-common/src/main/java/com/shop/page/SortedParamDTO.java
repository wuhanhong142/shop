package com.shop.page;

import lombok.Data;

import java.io.Serializable;

@Data
public class SortedParamDTO implements Serializable {

    /**
     * 排序的字段名称
     */
    private String field;
    /**
     * 排序的方向，正序排列 or 逆序排列
     */
    private String direction;

}
