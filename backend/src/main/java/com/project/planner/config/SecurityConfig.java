package com.project.planner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Cria o encriptador que usamos na camada de Service
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    // Desativa o bloqueio padrão das rotas para você continuar testando sua API em paz
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desativa proteção CSRF (padrão para APIs Stateless)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permite que todas as rotas sejam acessadas sem Token por enquanto
                );

        return http.build();
    }
}
