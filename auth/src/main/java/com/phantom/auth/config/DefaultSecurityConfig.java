package com.phantom.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author Joe Grandja
 */
@EnableWebSecurity
@Configuration(proxyBeanMethods = false)
public class DefaultSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                // 任何请求都需要认证（不对未登录用户开放）
                .authorizeHttpRequests(authorize ->
                        authorize.anyRequest().authenticated()
                )
                // 表单登录
                .formLogin(withDefaults())
                .logout().logoutSuccessUrl("http://127.0.0.1:8000")
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }

}
