package com.capg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controllermvc {

	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		System.out.println("helloooo");
		return new ModelAndView("helloPage","message","Hello! Welcome!");
	}
	
	@RequestMapping("/cello")
	public ModelAndView sayHello1() {
		System.out.println("celloooo");
		return new ModelAndView("photo","message","cello! Welcome!");
	}
	
	
}
