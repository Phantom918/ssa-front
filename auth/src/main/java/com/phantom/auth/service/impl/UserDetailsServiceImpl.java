package com.phantom.auth.service.impl;

import com.phantom.auth.entity.User;
import com.phantom.auth.mapper.UserMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * spring security 用户认证
 *
 * @author lei.tan
 * @version 1.0
 * @date 2023/4/19 22:31
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Assert.notNull(username, "用户名不能为空!");
        User user = userMapper.selectUserAuthorityByUsername(username);
        // 用户是否有效
        boolean enabledFlag = user.getStatus() == 0;
        // 注意: 这里使用的是spring security的UserDetails, 而不是自己的User，即使使用自己的User实现了UserDetails接口也不行，会报一个如下的错误，
        // Ø意思就是自己的定义的这个类不在白名单中，所以需要使用spring security的UserDetails
        // org.springframework.security.authentication.BadCredentialsException is not whitelisted.
        // If you believe this class is safe to deserialize, please provide an explicit mapping
        // using Jackson annotations or by providing a Mixin. If the serialization is only done
        // by a trusted source, you can also enable default typing. See #4370 for details; nested exception is java.
        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                enabledFlag,
                enabledFlag,
                enabledFlag,
                enabledFlag,
                getAuthorities(user));
        if (!userDetails.isEnabled()) {
            throw new DisabledException("用户已被禁用");
        } else if (!userDetails.isAccountNonLocked()) {
            throw new LockedException("用户已被锁定");
        } else if (!userDetails.isAccountNonExpired()) {
            throw new AccountExpiredException("用户已过期");
        } else if (!userDetails.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("用户凭证已过期");
        }
        return userDetails;
    }

    /**
     * 获取用户权限
     *
     * @param user 用户
     * @return 权限集合
     */
    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .flatMap(role -> role.getAuthorities().stream())
                .map(authority -> new SimpleGrantedAuthority(authority.getUrl()))
                .collect(Collectors.toList());
        log.info("用户[{}]的权限有: {}", user.getUsername(), authorities);
        return authorities;
    }

}
