package com.shop.dto;

import java.util.Date;

import com.shop.core.model.BaseDTO;

import java.io.Serializable;

import lombok.Data;


@Data
public class RoleDTO extends BaseDTO implements Serializable {

    /**
     * 角色名称
     */
    private String roleName;
}

