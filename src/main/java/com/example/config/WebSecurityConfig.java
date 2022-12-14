package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        // limit access
        http.authorizeRequests()
                    .antMatchers("/")
                    .permitAll()
                    .antMatchers("/login")
                    .permitAll()
                    .anyRequest()
                    .authenticated();

        // oauth
        http.oauth2Login()
            .defaultSuccessUrl("/success")
            .failureUrl("/login?error");
        return http.build();
    }
}
