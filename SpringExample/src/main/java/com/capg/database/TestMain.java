package com.capg.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestMain {

	public static void main(String[] args) {
//		Resource resource=new  ClassPathResource("applicationContext.xml");
//		BeanFactory factory=new XmlBeanFactory(resource);

		//or
		
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//DbConnection db2=(DbConnection)context.getBean("oracle");
		DbConnection db2=(DbConnection)context.getBean("mysql");
		
		try {
			Class.forName(db2.getDriver());
			Connection con = DriverManager.getConnection(db2.getUrl(), db2.getUserName(), db2.getPassword());
			PreparedStatement ps = con.prepareStatement("select * from employee");
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				//System.out.println(rs.getInt(2)+" "+rs.getString(1)+" "+ rs.getInt(5));
				System.out.println("working");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
