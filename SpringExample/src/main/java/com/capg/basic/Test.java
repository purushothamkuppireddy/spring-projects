package com.capg.basic;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {

	public static void main(String[] args) {
		Resource resource=new  ClassPathResource("applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		Customer c=(Customer)factory.getBean("custbean");
		System.out.println(c.getName());
		
		Customer c2=(Customer)factory.getBean("custbean");
		System.out.println(c.getName());
		
		c2.setName("balakrishana");
		System.out.println(c.getName());
		
		
	}

}
