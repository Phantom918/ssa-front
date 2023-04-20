package com.phantom.auth.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author lei.tan
 * @since 2023-04-20
 */
@Data
@TableName("role")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(title = "Role对象", description = "角色")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(title = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(title = "角色编码")
    private String code;

    @Schema(title = "角色名称")
    private String name;

    @Schema(title = "角色描述")
    private String description;

    @Schema(title = "状态(0:启用 1:禁用)")
    private Integer status;

    @Schema(title = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @Schema(title = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @Schema(title = "备注")
    private String remark;

    @Schema(title = "权限列表")
    private List<Authority> authorities;

}
