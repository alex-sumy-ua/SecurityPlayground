package com.northcoders.SecurityPlayground.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1") // Use: localhost:8082/api/v1/jokes
public class SecurityController {

    @GetMapping("/open/greeting")    // usage: http://localhost:8082/api/v1/open/greeting
    public static String getOpenGreeting() {
        return "Greetings, distant user.";
    }

//    @GetMapping("/protected/greeting")    // usage: http://localhost:8082/api/v1/protected/greeting
//    public static String getProtectedGreeting() {
//        return "Hello special people!";
//    }

    @GetMapping("/protected/greeting")    // usage: http://localhost:8082/api/v1/protected/greeting
    public static ResponseEntity<String> getProtectedGreeting(@AuthenticationPrincipal OAuth2User user) {
        String username = user.getAttribute("name");
        String githubUsername = user.getAttribute("login");
        return new ResponseEntity<>("Hey " + username + " " + githubUsername + "!", HttpStatus.OK);
    }

//    @GetMapping("/h2-console")
//    public static ResponseEntity<>
}
