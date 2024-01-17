package com.Vaik.ocaz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    // @Bean
    // SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http.authorizeRequests().anyRequest().permitAll();
    //     return http.build();
    // }

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //      http      //other configure params.
    //          .csrf().disable();
    // }

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest()
      .permitAll())
      .csrf(AbstractHttpConfigurer::disable);
    return http.build();
}
}
