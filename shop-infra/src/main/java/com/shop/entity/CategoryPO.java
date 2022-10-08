package com.shop.entity;

import java.util.Date;

import com.shop.core.model.BasePO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_category")
public class CategoryPO extends BasePO {


    /**
     * 商家ID
     */
    private Long shopId;

    /**
     * 分类名称
     */
    private String name;
}

