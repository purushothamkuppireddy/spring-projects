package com.capg.restuarent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRestuarent {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("restuarentApplContext.xml");
		
		Restuarent restuarent=(Restuarent)context.getBean("restuarentbean");
		restuarent.display();
		

	}

}
