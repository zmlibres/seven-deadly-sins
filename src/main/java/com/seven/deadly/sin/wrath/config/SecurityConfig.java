package com.seven.deadly.sin.wrath.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/*
    SecurityContextPersistenceFilter
            ↓
    BasicAuthenticationFilter
            ↓
    AuthorizationFilter
            ↓
    DispatcherServlet
*/

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable()) // disable csrf
                .authorizeHttpRequests(auth ->
                        auth.anyRequest().authenticated() //add authorizationFilter — require authentication in security context
                )
                .httpBasic(Customizer.withDefaults()); // add BasicAuthenticationFilter — reads Authorization: Basic xxx

        return http.build();
    }

}
