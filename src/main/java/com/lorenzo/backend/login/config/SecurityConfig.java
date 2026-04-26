package com.lorenzo.backend.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita CSRF (API stateless, sem uso de sessão)
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Libera todos os endpoints relacionados a usuários (CRUD completo)
                        .requestMatchers("/usuarios/**").permitAll()
                        // Qualquer outra rota exige autenticação
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
