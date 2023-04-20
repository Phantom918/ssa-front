package com.phantom.provider.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * swagger3 配置
 *
 * @author lei.tan
 * @version 1.0
 * @date 2023/4/18 14:37
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenApi() {
        return new OpenAPI()
                .info(new Info().title("provider 接口文档")
                        .description("provider 微服务模块的API文档")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("外部文档")
                        .url("https://springshop.wiki.github.org/docs"));
    }


}
