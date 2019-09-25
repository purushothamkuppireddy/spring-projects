package com.capg.pack1;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.capg.injection.Student;

public class Main {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		System.out.println("hi");
		Student2 student = (Student2) factory.getBean("Studentbean2");
//		Address address=student.getAddress();
//		System.out.println(address.getCity());
//		System.out.println(address.getState());

		// List<Address> ad=student.getAddresses();
//		System.out.println(ad.get(0).getCity());
//		System.out.println(ad.get(0).getState());
		
		// Map<String, Address> ad = student.getAddresses();
//		System.out.println(ad.get("one").getCity());
//		System.out.println(ad.get("one").getState());
//		System.out.println(ad.get("two").getCity());
//		System.out.println(ad.get("two").getState());

		Set<Address> set = student.getAddresses();
		System.out.println(student.getName());
		System.out.println(student.gethNo());
		for(Address add:set) {
		System.out.println(add.getCity());
		System.out.println(add.getState());
		}
	}

}
