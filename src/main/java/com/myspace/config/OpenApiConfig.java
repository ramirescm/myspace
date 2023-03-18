package com.myspace.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("REST API with Java 18 and Spring Boot")
                        .version("v1")
                        .description("MySpace Social Media")
                        .termsOfService("https://github.com/ramirescm/myspace")
                        .license(
                                new License()
                                    .name("APACHE 2.0")
                                    .url("https://github.com/ramirescm/myspace")));
    }
}
