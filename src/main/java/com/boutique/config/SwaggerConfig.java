
package com.boutique.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI configureSwagger() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Boutique Documentation")
                        .description("API pour la gestion de la boutique avec sécurité intégrée")
                        .version("1.0")
                        .contact(new Contact()
                                .email("kennedy@gmail.com")
                                .name("Ibrahima Dione")
                                .url("https://github.com/kenndy")
                        )
                )
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(
                        new Components()
                                .addSecuritySchemes(
                                        "bearerAuth",
                                        new SecurityScheme()
                                                .name("bearerAuth")
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                );
    }
}