package com.shop.entity;

import java.util.Date;

import com.shop.core.model.BasePO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_resource")
public class ResourcePO extends BasePO {


    /**
     * 父级
     */
    private Long parentId;

    /**
     * 路径
     */
    private String url;

    /**
     * 图标
     */
    private String icon;

    private String name;
}

