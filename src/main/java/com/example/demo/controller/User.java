package com.example.demo.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * todo
 * author：xuyy
 * date：2021/3/3  6:01 下午
 */

@Data
@ApiModel(value = "用户")
public class User {

    @ApiModelProperty(value = "用户名", example = "xuyy",required = true)
    private String username;
}
