package com.cg.capstore.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.model.Merchant;
import com.cg.capstore.service.MerchantService;


	@RestController
	
	//This annotation is used to give access to other origins...to access 7620 from 4200
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	
	@ComponentScan("com")
	@EntityScan("com")
	public class MerchantController {
		@Autowired
		MerchantService service;
		
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String start() {
			return "Merchant";
		}
		
		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public Merchant register(@RequestBody Merchant merchant) {
			merchant.setApprovalStatus("Inactive");
			Merchant m=service.register(merchant);
			return m;
		}
		@RequestMapping(value = "/addByAdmin", method = RequestMethod.POST)
		public Merchant addByAdmin(@RequestBody Merchant merchant) {
			merchant.setApprovalStatus("Active");
			Merchant m=service.addByAdmin(merchant);
			return m;
		}
		@RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
		public Merchant AddMerchant(@RequestBody int merchantId) {
			
			Merchant merchant=service.addMerchant(merchantId);
			return merchant;
		}
		@RequestMapping(value = "/remove", method = RequestMethod.POST)
		public Merchant removeMerchant(@RequestBody int merchantId) {
			
			Merchant merchant=service.removeMerchant(merchantId);
			return merchant;
		}
		
		@RequestMapping(value = "/getAll", method = RequestMethod.GET)
		public ArrayList<Merchant> getByInactive() {
			
			ArrayList<Merchant> al=service.getByInactive();
			return al;
		}
		
		

		
		
	}


