package com.mine.upmsx.dto;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: 【登录信息表】交互层
 * @author: Generated by Jax-li
 * @create: 2020-08-12
 * @version: v1.0
 */
@Data
@ApiModel(value = "【登录信息表】交互层")
public class SysUserBaseDTO {

    @ApiModelProperty(value = "用户Id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "移动电话号码")
    private String mobile;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "身份证号码")
    private String idCard;

    @ApiModelProperty(value = "是否锁定  1 是 0 否")
    private Integer isLocked;

    @ApiModelProperty(value = "是否启用  1 是 0 否 ")
    private Integer isEnabled;

    @ApiModelProperty(value = "最后登录时间")
    private Date lastLoginTime;

    @TableLogic
    @ApiModelProperty(value = "是否删除 1 是 0 否 ")
    private Integer isDeleted;

    @ApiModelProperty(value = "创建用户Id")
    private Long createUserId;

    @ApiModelProperty(value = "创建用户名称")
    private String createUserName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改用户Id")
    private Long updateUserId;

    @ApiModelProperty(value = "更新用户名称")
    private String updateUserName;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}