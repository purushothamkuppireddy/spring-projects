package com.capg.controllerpkgg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	


			@RequestMapping(name="/",method=RequestMethod.GET)
			public ModelAndView sayHello() {
				System.out.println("in home ");
				return new ModelAndView("home","message"," Welcome to MVC");
					
				}
			@RequestMapping(name="/welcomeuser",method=RequestMethod.POST)
			public ModelAndView sayHello2(@RequestParam(name="uname")String name) {
				System.out.println("in welcome ");
				System.out.println("NAme is:"+name);
					return new ModelAndView("welcome","msg",name);
			
		}
}
