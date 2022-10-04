package com.ll.exam.app348.security;

import com.ll.exam.app348.security.handler.SecuritySuccessHandler;
import com.ll.exam.app348.security.handler.SecurityFailureHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final SecuritySuccessHandler successHandler;
    private final SecurityFailureHandler failureHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionCreationPolicy(STATELESS)
                )
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/**").permitAll()
                )
                .formLogin(formLogin ->
                        formLogin
                                .successHandler(successHandler)
                                .failureHandler(failureHandler)
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .usernameParameter("username")
                                .passwordParameter("passwd")
                                .permitAll()
                );

        return http.build();
    }
}
