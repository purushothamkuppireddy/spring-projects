package com.capg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.Product;
import com.capg.service.ProductService;
import com.capg.userException.UserNotFoundException;

import java.util.ArrayList;

@ComponentScan("com")
@RestController
public class MyController {

	@Autowired
	ProductService productservice;

	@RequestMapping("/")
	public String general() {
		System.out.println("hi");
		return "welcome";
	}

	@PostMapping("/add")
	public ResponseEntity insertData(@RequestBody Product product) {
		productservice.addProduct(product);
		return new ResponseEntity("Succesfully added",HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity updateData(@RequestBody Product product) {
		productservice.updateProduct(product);
		return new ResponseEntity("Updated",HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity deleteData(@RequestBody int pId) {
		productservice.deleteProduct(pId);
		return new ResponseEntity("Deleted",HttpStatus.OK);
	}
	
	@GetMapping("/getById")
	public ResponseEntity getByPid(@RequestBody int pId) {
		Product product=productservice.getByPid(pId);
//		if(product!=null)
//		return  new ResponseEntity(product,HttpStatus.OK);
//		else
//		return  new ResponseEntity("Product is not available with "+pId,HttpStatus.OK);
		if(product==null) {
			throw new UserNotFoundException("user not found "+pId);
		}
		else
			return new ResponseEntity("success",HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ArrayList<Product> getAllProducts(){
		ArrayList<Product> products = productservice.getAll();
		return products;
	}
	
}
