package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.cg.model.CustomerDetails;
import com.cg.model.TransactionDetails;
import com.cg.utility.Database;

@Repository
public class TransactionDaoImpl implements TransactionDao {

	@PersistenceContext
	EntityManager entityManager;

	// Deposit
	public int deposit(int accountNo, int amt) {
		// TODO Auto-generated method stub
		int amount = 0;
		CustomerDetails cd = entityManager.find(CustomerDetails.class, accountNo);
		amount = cd.getBalance() + amt;
		cd.setBalance(amount);

		return amount;
	}

	// Withdraw
	public int withdraw(int accountNo, int amt) {
		// TODO Auto-generated method stub
		int amount = 0;
		CustomerDetails cd = entityManager.find(CustomerDetails.class, accountNo);
		if (cd.getBalance() > amt) {
			amount = cd.getBalance() - amt;
			Query query = entityManager.createQuery("update CustomerDetails set balance = :balanceAmt where accountNo= :accountNumber");
			query.setParameter("balanceAmt", amount);
			query.setParameter("accountNumber", accountNo);
			query.executeUpdate();

		}
		return amount;
	}

//ShowBalance
	public int showBalance(int accountNo) {
		// TODO Auto-generated method stub
		int amount = 0;
		CustomerDetails cd = entityManager.find(CustomerDetails.class, accountNo);
		amount = cd.getBalance();
		return amount;
	}

//Fundtransfer
	public TransactionDetails fundTransfer(int accountNo, TransactionDetails transaction) {

		TransactionDetails td = null;

		CustomerDetails from = entityManager.find(CustomerDetails.class, accountNo);
		CustomerDetails to = entityManager.find(CustomerDetails.class, transaction.getToAcc());
		if (from.getBalance() > transaction.getAmt()) {
			
			if(to!=null) {
			from.setBalance(from.getBalance() - transaction.getAmt());
			to.setBalance(to.getBalance() + transaction.getAmt());
			td = new TransactionDetails();
			td.setFromAcc(accountNo);
			td.setToAcc(transaction.getToAcc());
			td.setAmt(transaction.getAmt());
			}
		}
		return td;
	}
//Transaction Table insertion
	public int insertTransaction(TransactionDetails transaction) {

		
		if (transaction!=null) {
			entityManager.persist(transaction);
			return transaction.getTransactionId();
		}
		else {
			return 0;
			
		}
		

		
	}

}
