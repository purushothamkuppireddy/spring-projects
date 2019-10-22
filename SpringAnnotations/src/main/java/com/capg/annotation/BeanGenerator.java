package com.capg.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanGenerator {

	@Bean("userId")
	public User getUser()
	{
		User u=new User();
		u.setUserName("James");
		u.setPassword("mrs.James");
		return u;
		
	}
	
}
