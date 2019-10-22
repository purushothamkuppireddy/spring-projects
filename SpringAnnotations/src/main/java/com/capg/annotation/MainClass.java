package com.capg.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext appContext=new AnnotationConfigApplicationContext(BeanGenerator.class);
		
		User us=(User)appContext.getBean("userId");
		System.out.println(us.getUserName());
		System.out.println(us.getPassword());
		
	}

}
