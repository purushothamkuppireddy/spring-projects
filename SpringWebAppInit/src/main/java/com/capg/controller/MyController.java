package com.capg.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.capg.model.User;

@Controller
public class MyController {

	@RequestMapping("/")
	public String first() {
	return "index";
	
//	public ModelAndView first() {
//		return new ModelAndView("index");
	}

	@RequestMapping("/insert")
	public ModelAndView insert(@Validated @ModelAttribute("user") User user,BindingResult br) {

		if(br.hasErrors()) {
			return new ModelAndView("index");
		}else {
		// ApplicationContext context=new ClassPathXmlApplicationContext("hibernate.cfg.xml");
		// Configuration configuration=new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(user);
		transaction.commit();
		System.out.println("inserted successfully");
		// return new ModelAndView("insert", "message", "succesfully Inserted");
		return new ModelAndView("redirect:/display");
	}
	}

	@RequestMapping("/display")
	public ModelAndView select(Model m) throws ClassNotFoundException, SQLException {

		Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query queryResult = session.createQuery("from User");
		List<User> result = queryResult.list();
		m.addAttribute("Li", result);
		return new ModelAndView("display");
	}

	@RequestMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable String id) throws ClassNotFoundException, SQLException {
		System.out.println(id);
		Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("delete from User where mobile =:stockCode");
		query.setParameter("stockCode", id);
		int i = query.executeUpdate();
		transaction.commit();

		if (i == 1) {
			System.out.println("deleted Successfully");
			return new ModelAndView("redirect:/display");
		} else {
			System.out.println("Error in deleting");
			return new ModelAndView("redirect:/display");
		}
	}

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable String id, Model m) throws ClassNotFoundException, SQLException {
		System.out.println(id);
		Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("mobile", id));
		User user = (User) criteria.uniqueResult();
		
		m.addAttribute("u", user);

		return new ModelAndView("update");

	}

	@RequestMapping("/update")
	public ModelAndView update(@ModelAttribute("user") User user) throws ClassNotFoundException, SQLException {

		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
    	Session session= sessionFactory.openSession();
    	Transaction transaction= session.beginTransaction();
    	session.update(user);
		transaction.commit();
    	System.out.println("succesfully updated");
    	return new ModelAndView("redirect:/display");
    	
    	
//    	Query query = session.createQuery("update User set name= :NAme,password= :Pass where mobile= :Mob");
//    	query.setParameter("NAme",user.getName());
//    	query.setParameter("Pass", user.getPassword());
//    	query.setParameter("Mob",user.getMobile());
//    	
//    	int i = query.executeUpdate();
//    	//transaction.commit(); 	
//		if (i==1) {
//			System.out.println("succesfully updated");
//			return new ModelAndView("redirect:/display");
//		} else {
//			System.out.println("error in updating");
//			return new ModelAndView("redirect:/display");
//		}

	}

}
