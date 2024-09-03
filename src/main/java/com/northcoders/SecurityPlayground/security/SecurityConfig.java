//package com.northcoders.SecurityPlayground.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig {
//
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
////        http.authorizeHttpRequests(auth -> {
////            auth.requestMatchers("/api/v1/protected/greeting").authenticated();
////            auth.requestMatchers("/api/v1/open/greeting").permitAll();
////        }).formLogin(Customizer.withDefaults());
////
////        return http.build();
////    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests(auth -> {
//            auth.requestMatchers("/api/v1/protected/greeting").authenticated();
//            auth.requestMatchers("/api/v1/open/greeting").permitAll();
//        }).oauth2Login(Customizer.withDefaults());
//
//        return http.build();
//    }
//
//
//}
package com.northcoders.SecurityPlayground.security;

import com.northcoders.SecurityPlayground.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, UserService userService) throws Exception {
        http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/api/v1/protected/greeting").authenticated();
                    auth.requestMatchers("/api/v1/open/greeting").permitAll();
                    auth.requestMatchers("/h2-console/**").permitAll();  // Allow access to H2 console
                })
                .oauth2Login(oauth2 -> oauth2.userInfoEndpoint().userService(userService))  // Register custom user service
                .headers(headers -> headers.frameOptions().disable())  // Disable frame options to allow H2 console
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))  // Disable CSRF for H2 console
                .httpBasic(Customizer.withDefaults());  // Use basic authentication for testing

        return http.build();
    }
}