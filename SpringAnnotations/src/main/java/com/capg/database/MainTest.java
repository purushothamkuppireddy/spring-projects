package com.capg.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.capg.annotation.BeanGenerator;

public class MainTest {

	public static void main(String[] args) {
		AbstractApplicationContext appContext=new AnnotationConfigApplicationContext(DbBeanGenerator.class);
		
		Oracle db2=(Oracle)appContext.getBean("oracle");
		//Mysql db2=(Mysql)appContext.getBean("mysql");
		try {
			Class.forName(db2.getDriver());
			System.out.println(db2.getUserName()+" "+db2.getPassword());
			Connection con = DriverManager.getConnection(db2.getUrl(), db2.getUserName(), db2.getPassword());
			PreparedStatement ps = con.prepareStatement("select * from employee");
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(2)+" "+rs.getString(1)+" "+ rs.getInt(5));
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


