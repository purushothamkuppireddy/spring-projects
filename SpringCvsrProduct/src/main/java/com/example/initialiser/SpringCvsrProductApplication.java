package com.example.initialiser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.capg.controller")
@SpringBootApplication

public class SpringCvsrProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCvsrProductApplication.class, args);
	}

}
