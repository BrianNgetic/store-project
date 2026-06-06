package com.storeproject.config;


import org.springframework.context.annotation.Bean;
//import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.Customizer;
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
            .requestMatchers(HttpMethod.PUT, "/product/update-product/**").hasAuthority("ROLE_ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/product/delete-product/**").hasAuthority("ROLE_ADMIN")
            .requestMatchers(HttpMethod.POST , "/product/add-product/**").hasAnyAuthority("ROLE_ADMIN")
           .requestMatchers(HttpMethod.GET, "/register").permitAll()
            .requestMatchers(HttpMethod.POST, "/register").permitAll()
            .requestMatchers("/error").permitAll()
            .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .failureUrl("/login?error")
                .permitAll()
              

            )
            
            .formLogin(Customizer.withDefaults())
            .exceptionHandling(ex -> ex.accessDeniedHandler(
                (req, res, e) ->{
                    res.setStatus(403);
                    res.getWriter().write("Admin priviledges required");
                })
                )
            .logout(logout -> logout.permitAll())
        ;

            return http.build();

  }



}
