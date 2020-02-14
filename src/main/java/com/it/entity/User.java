package com.it.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("UserEntity")
public class User {
    @ApiModelProperty("user_name")
    public String username;
    @ApiModelProperty("user_password")
    public String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
