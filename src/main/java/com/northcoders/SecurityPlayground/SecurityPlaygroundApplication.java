package com.northcoders.SecurityPlayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.northcoders.SecurityPlayground"})
public class SecurityPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityPlaygroundApplication.class, args);
	}

}


