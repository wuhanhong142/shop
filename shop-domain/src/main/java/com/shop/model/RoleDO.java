package com.shop.model;

import java.util.Date;

import com.shop.core.model.BaseDO;

import java.io.Serializable;

import lombok.Data;

@Data
public class RoleDO extends BaseDO {


    /**
     * 角色名称
     */
    private String roleName;
}

