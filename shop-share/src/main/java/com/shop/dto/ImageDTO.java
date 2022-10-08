package com.shop.dto;

import java.util.Date;

import com.shop.core.model.BaseDTO;

import java.io.Serializable;

import lombok.Data;


@Data
public class ImageDTO extends BaseDTO implements Serializable {

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

