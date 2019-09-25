package com.capg.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {

	public static void main(String[] args) {
		
		Resource resource=new  ClassPathResource("applicationContext.xml");
		
		BeanFactory factory=new XmlBeanFactory(resource);
		System.out.println("hi");
		Student student=(Student)factory.getBean("Studentbean1");
		System.out.println(student.getName());
		System.out.println(student.gethNo());
		//student.displayInfo();
	}
}