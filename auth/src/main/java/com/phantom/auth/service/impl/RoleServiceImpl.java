package com.phantom.auth.service.impl;

import com.phantom.auth.entity.Role;
import com.phantom.auth.mapper.RoleMapper;
import com.phantom.auth.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author lei.tan
 * @since 2023-04-20
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
