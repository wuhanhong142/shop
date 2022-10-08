package com.shop.model;

import lombok.Data;

import java.util.List;

@Data
public class UserModel {
    private UserDO user;
    private List<RoleDO> roles;
    private List<ResourceDO> resources;

    public UserModel(UserDO user, List<RoleDO> roles, List<ResourceDO> resources) {
        this.user = user;
        this.roles = roles;
        this.resources = resources;
    }
}
