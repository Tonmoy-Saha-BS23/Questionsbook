package com.bs23.Questionsbook.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpemAPI(){
        final Info info = new Info().title("QuestionBook").version("1.0.0")
                .license(new License().name("© Brain Station 23 Ltd.").url("https://brainstation-23.com"));
        final OpenAPI openAPI = new OpenAPI().info(info);
        return openAPI;
    }
}
