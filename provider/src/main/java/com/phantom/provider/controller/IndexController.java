package com.phantom.provider.controller;

import com.phantom.provider.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * TODO
 *
 * @author lei.tan
 * @version 1.0
 * @date 2023/4/18 14:49
 */
@Slf4j
@RestController
@Tag(name = "IndexController", description = "index相关api")
public class IndexController {

    @GetMapping("/hello")
    @ApiResponse(responseCode = "200", description = "成功")
    @Operation(summary = "获取用户详情", description = "返回用户详情")
    public ResponseEntity<User> index(@Parameter(name = "name", description = "名称") String name) {
        log.info("hello, {}", name);
        User user = new User();
        user.setId(1L);
        user.setUsername(name);
        user.setPassword("password");
        user.setNickname("纳西妲");
        user.setEmail("490316645@qq.com");
        user.setPhone("123456789");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        return ResponseEntity.ok(user);
    }

}
