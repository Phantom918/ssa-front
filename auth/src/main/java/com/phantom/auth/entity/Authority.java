package com.phantom.auth.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author lei.tan
 * @since 2023-04-20
 */
@Data
@TableName("authority")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(title ="Authority对象", description="权限表")
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(title  = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(title  = "名称")
    private String name;

    @Schema(title  = "编码")
    private String code;

    @Schema(title  = "地址链接")
    private String url;

    @Schema(title  = "权限描述")
    private String description;

    @Schema(title  = "权限类型 1:接口，2:菜单")
    private Integer type;

    @Schema(title  = "请求方式(get | delete | query | update)")
    private String method;

    @Schema(title  = "状态(0:有效 1:无效)")
    private Integer status;

    @Schema(title  = "排序")
    private Integer sort;

    @Schema(title  = "父级id")
    private Long parentId;

    @Schema(title  = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @Schema(title  = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @Schema(title  = "备注")
    private String remark;


}
