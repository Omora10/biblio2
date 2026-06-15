package com.biblio2.biblio2.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de Swagger/OpenAPI
 * Habilita la documentación interactiva de la API en /swagger-ui.html
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Biblio2 API")
                        .version("1.0.0")
                        .description("API REST para gestión de libros, usuarios y préstamos")
                        .contact(new Contact()
                                .name("Biblio2 Team")
                                .email("support@biblio2.com")));
    }
}
