package com.cg.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.utility.Database;
import com.cg.model.CustomerDetails;
import com.cg.model.TransactionDetails;
import com.cg.service.BankService;
import com.cg.service.TransactionService;



@RestController

//This annotation is used to give access to other origins...to access 7620 from 4200
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class HomeController {
	@Autowired
	BankService bank;
	@Autowired
	TransactionService tService;
	
	Database d = new Database();
	int accountNo;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start() {
		return "Hello";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public int register(@RequestBody CustomerDetails customer) {
		CustomerDetails cd= bank.register(customer);
		return cd.getAccountNo();
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public int login(@RequestBody CustomerDetails c) {
		
		accountNo = bank.login(c);
		return accountNo;
	}

	@RequestMapping(value = "/deposit", method = RequestMethod.PUT)
	public int deposit(@RequestBody int amt) {
		int amount = 0;
		if (accountNo != 0) {
			amount = tService.deposit(accountNo, amt);
		}
		return amount;
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.PUT)
	public int withdraw(@RequestBody int amt) {
		int amount = 0;
		if (accountNo != 0) {
			amount = tService.withdraw(accountNo, amt);
		}

		return amount;

	}

	@RequestMapping(value = "/showbalance", method = RequestMethod.GET)
	public int showBalance() {
		int amount = 0;
		if (accountNo != 0) {
			amount = tService.showBalance(accountNo);
		}
		return amount;

	}

	@RequestMapping(value = "/fundtransfer", method = RequestMethod.PUT)
	public int fundTransfer(@RequestBody TransactionDetails transaction) {
		int td = 0;
		if (accountNo != 0) {
			transaction = tService.fundTransfer(accountNo, transaction);
			 td = tService.insertTransaction(transaction);
		}

		return td;
	}

}
