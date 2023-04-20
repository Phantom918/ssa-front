package com.phantom.auth.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * token 认证异常处理
 *
 * @author lei.tan
 * @version 1.0
 * @date 2023/2/9 23:34
 */
@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info("[token认证异常]自定义处理.....");
        // 设置状态码为 403 以及请求头
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setHeader("Content-Type", "application/json;charset=utf-8");
        // 组装数据返回
        Map<String, Object> result = new HashMap<>(3);
        result.put("status", HttpStatus.FORBIDDEN.value());
        result.put("error", authException.getMessage());
        result.put("message", "token认证失败，请重新登录！");
        response.getWriter().write(JSON.toJSONString(result));
    }

}
