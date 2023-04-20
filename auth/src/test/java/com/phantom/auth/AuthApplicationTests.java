package com.phantom.auth;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.phantom.auth.entity.User;
import com.phantom.auth.mapper.UserMapper;
import com.phantom.auth.service.IUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Slf4j
@SpringBootTest
class AuthApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private IUserService userService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        List<User> userList = userMapper.selectList(null);
        log.info("userList: {}", JSON.toJSONString(userList));
    }

    @Test
    void testUserService() {
        List<User> userList = userService.list();
        log.info("userList: {}", JSON.toJSONString(userList));
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "admin");
        User user = userService.getOne(queryWrapper);
        log.info("user: {}", JSON.toJSONString(user));
        Page<User> userPage = new Page<>(1, 10);
        Page<User> page = userService.page(userPage);
        log.info("page: {}", JSON.toJSONString(page));
        Page<User> userPageDetail = userService.page(userPage, queryWrapper);
        log.info("userPageDetail: {}", JSON.toJSONString(userPageDetail));
    }

    @Test
    void testPasswordEncoder() {
        log.info(passwordEncoder.encode("123456"));
        User user = userMapper.selectUserAuthorityByUsername("phantom");
        log.info("user: {}", JSON.toJSONString(user));
    }

}
