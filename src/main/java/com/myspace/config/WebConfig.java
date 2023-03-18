package com.myspace.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.originPatterns:default}")
    private String corsOriginPatterns = "";
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // enables CORS requests from any origin to any endpoint in the application
        // registry.addMapping("/**");

        var allowedOrigins = corsOriginPatterns.split(",");
        registry.addMapping("/**")
                //.allowedMethods("GET", "POST", "PUT") // if needed to restrict methods
                .allowedMethods("*")
                .allowedOrigins(allowedOrigins)
                .allowCredentials(true);
    }
}
