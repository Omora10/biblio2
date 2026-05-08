package com.biblio2.biblio2.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuración de Seguridad
 * Define los beans de seguridad necesarios para la aplicación
 */
@Configuration
public class SecurityConfig {

    /**
     * Configurar el codificador de contraseñas (PasswordEncoder)
     * Utiliza BCrypt para encriptar las contraseñas de forma segura
     * @return BCryptPasswordEncoder configurado
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

