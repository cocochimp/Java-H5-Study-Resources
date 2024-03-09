package com.koko.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("3、模型类(实体类)")
public class User {

    @ApiModelProperty("4、属性-用户名")
    public String username;

    @ApiModelProperty("4、属性-密码")
    public String password;

}
