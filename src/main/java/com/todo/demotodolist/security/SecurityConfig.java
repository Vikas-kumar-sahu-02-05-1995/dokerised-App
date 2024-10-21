package com.todo.demotodolist.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

//@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfiguration {


    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF if you're working with stateless authentication
                .authorizeRequests()
                .requestMatchers("/todos", "/todos/getById/{id}", "/todos/save", "/todos/update/{id}", "/todos/delete/{id}", "/login").permitAll()
                .anyRequest().authenticated();

                http.build();
    }
}
