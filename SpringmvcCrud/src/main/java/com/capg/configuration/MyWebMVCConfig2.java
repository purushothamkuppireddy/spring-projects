package com.capg.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.capg")
public class MyWebMVCConfig2 {
	
	@Bean
	public ViewResolver getViewResolver() {
		System.out.println("in View resolver");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/Pages/");
		viewResolver.setSuffix(".jsp");
		System.out.println("1");
		return viewResolver;
	}

}
