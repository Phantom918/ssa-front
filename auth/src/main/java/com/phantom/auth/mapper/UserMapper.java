package com.phantom.auth.mapper;

import com.phantom.auth.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author lei.tan
 * @since 2023-04-19
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名查询用户及其权限信息
     *
     * @param username 用户名
     * @return 用户
     */
    User selectUserAuthorityByUsername(@Param("username") String username);

}
