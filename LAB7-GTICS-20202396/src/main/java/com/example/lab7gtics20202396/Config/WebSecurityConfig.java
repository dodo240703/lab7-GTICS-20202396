package com.example.lab7gtics20202396.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    // Configuramos la encriptación de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((requests) -> requests
                        // Configuración de permisos por roles
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/gerente/**").hasRole("GERENTE")
                        .requestMatchers("/cliente/**").hasRole("CLIENTE")
                        // Permitir acceso a todos los usuarios a la página de login y registro
                        .requestMatchers("/", "/login", "/register").permitAll()
                        // Cualquier otra solicitud requiere autenticación
                        .anyRequest().authenticated()
                )
                // Configuración del formulario de login
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                // Configuración del logout
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .permitAll()
                );

        return http.build();
    }
}
