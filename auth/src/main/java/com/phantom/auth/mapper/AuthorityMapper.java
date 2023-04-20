package com.phantom.auth.mapper;

import com.phantom.auth.entity.Authority;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author lei.tan
 * @since 2023-04-20
 */
public interface AuthorityMapper extends BaseMapper<Authority> {


    /**
     * 根据角色id查询权限
     *
     * @param roleId 角色id
     * @return 权限列表
     */
    List<Authority> selectAuthorityByRoleId(@Param("roleId") Long roleId);

}
