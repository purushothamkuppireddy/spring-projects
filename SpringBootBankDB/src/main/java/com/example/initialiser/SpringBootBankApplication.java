package com.example.initialiser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg")
public class SpringBootBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBankApplication.class, args);
	}

}
