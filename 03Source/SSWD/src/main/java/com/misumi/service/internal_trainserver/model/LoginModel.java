package com.misumi.service.internal_trainserver.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginModel {

    @ApiModelProperty("用户名")
    private String sname;

    @ApiModelProperty("密码")
    private String password;
}
