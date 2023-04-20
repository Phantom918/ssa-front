package com.phantom.auth.service;

import com.phantom.auth.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lei.tan
 * @since 2023-04-19
 */
public interface IUserService extends IService<User> {

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 用户
     */
    User getUserByUsername(String username);

}
