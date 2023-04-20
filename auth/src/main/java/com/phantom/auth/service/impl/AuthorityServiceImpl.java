package com.phantom.auth.service.impl;

import com.phantom.auth.entity.Authority;
import com.phantom.auth.mapper.AuthorityMapper;
import com.phantom.auth.service.IAuthorityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author lei.tan
 * @since 2023-04-20
 */
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority> implements IAuthorityService {

}
