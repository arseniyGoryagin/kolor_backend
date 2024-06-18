package com.backend.kolor.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity()
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(registery ->{
            registery.requestMatchers("/auth/**").permitAll();
            registery.requestMatchers("/").permitAll();
            registery.anyRequest().authenticated();
        });
        return http.httpBasic().disable().build();
    }


}
