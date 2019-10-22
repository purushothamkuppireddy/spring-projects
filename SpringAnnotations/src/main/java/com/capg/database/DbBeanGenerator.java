package com.capg.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.capg.annotation.User;

@Configuration
@PropertySource("classpath:DBdata.properties")
public class DbBeanGenerator {
	
	@Autowired
	Environment environment;
	
		@Bean("oracle")
		public Oracle getUser()
		{
			//annotations using placeholders
			Oracle oracle=new Oracle();
			oracle.setDriver(environment.getProperty("driver"));
			oracle.setUrl(environment.getProperty("url"));
			oracle.setUserName(environment.getProperty("userName1"));
			oracle.setPassword(environment.getProperty("password"));
			return oracle;
			
		}
		
		@Bean("mysql")
		public Mysql getUser2()
		{
			// normal annotations
			Mysql mysql=new Mysql();
			mysql.setDriver("com.mysql.cj.jdbc.Driver");
			mysql.setUrl("jdbc:mysql://localhost:3306/kpr");
			mysql.setUserName("root");
			mysql.setPassword("root");
			return mysql;
			
		}
}


