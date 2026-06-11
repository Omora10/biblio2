package com.biblio2.biblio2.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuración de Seguridad
 * Define los beans de seguridad necesarios para la aplicación
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configura un PasswordEncoder NoOp para desarrollo
     * (NO usar en producción)
     * @return NoOpPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * Crear un UserDetailsService con las credenciales configuradas
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("Omora")
                .password("Jinxvi2205")
                .authorities("ROLE_USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    /**
     * Configurar la cadena de filtros de seguridad HTTP
     * Define qué endpoints requieren autenticación
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/login", "/login.html", "/static/**").permitAll()
                .antMatchers("/api/usuarios/registrar").permitAll()
                .antMatchers("/h2-console", "/h2-console/**").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/", true)
                .permitAll()
            .and()
            .httpBasic()
            .and()
            .headers().frameOptions().disable();
        
        return http.build();
    }
}

