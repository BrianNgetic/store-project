package com.storeproject.config;

import org.springframework.context.annotation.Bean;
// /import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.*;
@Configuration
public class SecurityConfig {
    @Bean
     public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
           
            .requestMatchers("/login",
                "/register",
                "/css/**",
                "/js/**",
                "/images/**").permitAll()
            .requestMatchers(HttpMethod.PUT, "/update-product/*").hasAuthority("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/delete-product/*").hasAuthority("ADMIN")
           .requestMatchers(HttpMethod.GET, "/register").permitAll()
            .requestMatchers(HttpMethod.POST, "/register").permitAll()
            
            .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error")
                .permitAll()

            )
            .logout(logout -> logout.permitAll());

            return http.build();

  }



}
