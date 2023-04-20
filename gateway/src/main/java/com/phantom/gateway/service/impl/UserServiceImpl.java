package com.phantom.gateway.service.impl;

import com.phantom.gateway.entity.User;
import com.phantom.gateway.mapper.UserMapper;
import com.phantom.gateway.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lei.tan
 * @since 2023-04-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
