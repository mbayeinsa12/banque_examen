package com.boutique.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI boutiqueeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Boutique")
                        .description("API pour la gestion de la boutique")
                        .version("1.0"));
    }
}