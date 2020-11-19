package com.mine.common.feign.entity.upmsx;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Transient;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * 【登录信息表】实体类
 *
 * @author jax-li
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user_base")
public class SysUserBase extends Model<SysUserBase> {

    /**
     *
     */
    private static final long serialVersionUID = 1083273531444623782L;

    @TableId
    @ApiModelProperty(value = "用户Id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "移动电话号码")
    private String mobile;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "身份证号码")
    @TableField("id_card")
    private String idCard;

    @ApiModelProperty(value = "是否锁定  1 是 0 否")
    @TableField("is_locked")
    private Boolean isLocked;

    @ApiModelProperty(value = "是否启用  1 是 0 否 ")
    @TableField("is_enabled")
    private Boolean isEnabled;

    @ApiModelProperty(value = "最后登录时间")
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "是否删除 1 是 0 否 ")
    @TableLogic(value = "0", delval = "1")
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建用户Id")
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private Long createUserId;

    @ApiModelProperty(value = "创建用户名称")
    @TableField(value = "create_user_name", fill = FieldFill.INSERT)
    private String createUserName;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改用户Id")
    @TableField(value = "update_user_id", fill = FieldFill.UPDATE)
    private Long updateUserId;

    @ApiModelProperty(value = "更新用户名称")
    @TableField(value = "update_user_name", fill = FieldFill.UPDATE)
    private String updateUserName;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @Transient
    @TableField(exist = false)
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
