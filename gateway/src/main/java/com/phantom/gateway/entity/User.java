package com.phantom.gateway.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author lei.tan
 * @since 2023-04-18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
@Schema(title="User对象", description="用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(title = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(title = "用户名")
    private String username;

    @Schema(title = "密码")
    private String password;

    @Schema(title = "别名")
    private String nickname;

    @Schema(title = "邮箱")
    private String email;

    @Schema(title = "电话")
    private String phone;

    @Schema(title = "创建时间")
    private LocalDateTime createTime;

    @Schema(title = "更新时间")
    private LocalDateTime updateTime;


}
