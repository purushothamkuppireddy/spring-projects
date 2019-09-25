package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;

@RestController
public class MyController {

	@Autowired
	JdbcTemplate jdbc;

	@RequestMapping("/")
	public ModelAndView general() {
		System.out.println("hi");
		return new ModelAndView("welcome");
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registration(@Validated @ModelAttribute("user") User userDetails,BindingResult br) {
		if(br.hasErrors()) {
			System.out.println("errors occured bcz validation");
			return new ModelAndView("welcome");
		}else {
		jdbc.update("insert into UserBoot values(?,?,?)", userDetails.getName(), userDetails.getMobile(),userDetails.getAddress());
		return new ModelAndView("redirect:/view");
	}
	}
	@RequestMapping("/view")
	public ModelAndView getDetails(Model m) {
		List<User> li = new ArrayList<User>();
		li = jdbc.query("select * from userBoot", new BeanPropertyRowMapper(User.class));
		m.addAttribute("li", li);
		return new ModelAndView("display");
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable String id) {
		jdbc.update("delete from UserBoot where mobile = ?", id);
		return new ModelAndView("redirect:/view");
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView updateDetails(@PathVariable String id, Model m) {
		User u = new User();
//		List<User> li = new ArrayList<User>();
//		li = jdbc.query("select * from userdetails where mobile = ?", new BeanPropertyRowMapper(User.class));
//		m.addAttribute("li", li);
		u = (User) jdbc.queryForObject("select * from userBoot where mobile= ?", new Object[] { id }, new BeanPropertyRowMapper(User.class));
		m.addAttribute("u", u);
		
		return new ModelAndView("update");
	}
	
	@RequestMapping("/update")
	public ModelAndView updateTheDetails(@ModelAttribute("user") User userDetails) {
		jdbc.update("update UserBoot set name = ?,address=? where mobile = ?", userDetails.getName(), userDetails.getAddress() ,userDetails.getMobile());
		return new ModelAndView("redirect:/view");
	}
	
	

}
