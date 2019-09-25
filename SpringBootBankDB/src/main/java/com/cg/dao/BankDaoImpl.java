package com.cg.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cg.model.CustomerDetails;
import com.cg.utility.Database;

@Repository
@EntityScan("com.cg.model")
public class BankDaoImpl implements BankDao {
	
	@PersistenceContext
	EntityManager entityManager;

	// Register
	public CustomerDetails register(CustomerDetails cd) {

		entityManager.persist(cd);
		
		return cd;
	}

	// Login
	public int login(CustomerDetails c) {
		int accountNo = 0;
		CustomerDetails cd = entityManager.find(CustomerDetails.class, c.getAccountNo());
		if (cd!=null&&cd.getPassword().equals(c.getPassword())) {
			accountNo = c.getAccountNo();
		}
		return accountNo;
	}

}
