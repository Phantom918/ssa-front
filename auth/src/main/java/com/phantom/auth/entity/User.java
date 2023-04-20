package com.phantom.auth.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author lei.tan
 * @since 2023-04-19
 */
@Data
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(title = "User对象", description = "用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(title = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @Schema(title = "用户名")
    private String username;

    @Schema(title = "密码")
    private String password;

    @Schema(title = "别名")
    private String nickname;

    @Schema(title = "性别(0:女 1:男)")
    private Integer sex;

    @Schema(title = "邮箱")
    private String email;

    @Schema(title = "电话")
    private String phone;

    @Schema(title = "状态(0:启用 1:禁用)")
    private Integer status;

    @Schema(title = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @Schema(title = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @Schema(title = "上次登录时间")
    private LocalDateTime lastLoginTime;

    @Schema(title = "备注")
    private String remark;

    @Schema(title = "角色列表")
    private List<Role> roles;


}
