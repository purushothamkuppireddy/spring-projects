package com.capg.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.capg.model.Employee;

@RestController
public class MyNewController {
	ArrayList<Employee> empList;

//	@RequestMapping("/")
//	public String first() {
//		return "index ";
//	}
	
	
	@RequestMapping(name = "/", method = RequestMethod.GET)
	public void start() {

		Employee employee = new Employee();
		employee.setName("Bob");
		employee.setId(101);

		Employee employee1 = new Employee();
		employee1.setName("ALice");
		employee1.setId(102);

		Employee employee2 = new Employee();
		employee2.setName("Peter");
		employee2.setId(103);

		empList = new ArrayList<Employee>();
		empList.add(employee);
		empList.add(employee1);
		empList.add(employee2);

	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public ArrayList<Employee> getAll(){
		
		return empList;
		
	}
	
	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public ResponseEntity insert(@RequestBody Employee employee)
	{
		
		empList.add(employee);
		return new ResponseEntity(HttpStatus.OK);
		
		
	}

	@RequestMapping(value="/getById/{id}", method=RequestMethod.GET)
	public Employee getById(@PathVariable int id) {
		Employee emp = new Employee();
		for(Employee employee : empList) {
			if(employee.getId() == id) {
				emp.setId(employee.getId());
				emp.setName(employee.getName());
				break;
			}
		}
		return emp;
		
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateStudent(@PathVariable int id,@RequestBody Employee emp) {

		for (Employee employ : empList) {
			if (employ.getId() == id) {
				employ.setName(emp.getName());
				break;
			}
		}
		return new ResponseEntity(HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity delStudent(@PathVariable int id) {

		for (Employee employ: empList) {
			if (employ.getId() == id) {
				empList.remove(employ);
				break;
			}
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	
	
	
	

}
