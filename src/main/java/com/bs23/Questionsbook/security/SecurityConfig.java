package com.bs23.Questionsbook.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
//    @Bean
//    public UserDetailsService userDetailsManager(){
//       return new MyUserDetailsService();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((configurer) ->
                configurer
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/signUp").permitAll()
                        .requestMatchers("/register").permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(login->
                        login
                                .loginPage("/loginForm")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                    )
                    .logout(logout->logout.permitAll())
                    .exceptionHandling(configurer->
                            configurer.accessDeniedPage("/access-denied"));
            return http.build();
        }


    @Bean
    public AuthenticationManager authManager(HttpSecurity http, UserDetailsService userDetailsService,
                                             PasswordEncoder passwordEncoder) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .parentAuthenticationManager(null)
                .build();
    }
    }
