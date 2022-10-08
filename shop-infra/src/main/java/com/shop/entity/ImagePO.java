package com.shop.entity;

import java.util.Date;

import com.shop.core.model.BasePO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_image")
public class ImagePO extends BasePO {


    /**
     * 图片归属ID
     */
    private Long businessId;

    /**
     * 图片类型
     */
    private String imageType;

    /**
     * 缩略图路径
     */
    private String thumbnailUrl;

    /**
     * 实际图片路径
     */
    private String imageUrl;
}

