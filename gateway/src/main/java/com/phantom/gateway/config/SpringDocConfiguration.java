package com.phantom.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger配置服务:读取gateway的路由配置，截取服务前缀，生成swagger分组
 *
 * @author lei.tan
 * @version 1.0
 * @date 2023/4/19 13:44
 */
@Slf4j
@Configuration
public class SpringDocConfiguration {

    @Bean
    @Lazy(false)
    public List<GroupedOpenApi> apis(RouteDefinitionLocator locator) {
        List<GroupedOpenApi> groups = new ArrayList<>();
        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
        assert definitions != null;
        for (RouteDefinition definition : definitions) {
            log.info("id:{}, {} ", definition.getId(), definition.getUri().toString());
        }
        definitions.stream()
                .filter(routeDefinition -> routeDefinition.getId().matches(".*-service"))
                .forEach(routeDefinition -> {
                    String name = routeDefinition.getId().replaceAll("-service", "");
                    GroupedOpenApi.builder()
                            .pathsToMatch("/" + name + "/**")
                            .group(name)
                            .build();
                });
        return groups;
    }

}
