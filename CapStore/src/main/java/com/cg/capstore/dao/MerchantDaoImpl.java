package com.cg.capstore.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.cg.capstore.model.Merchant;

	

	@Repository
	public class MerchantDaoImpl implements MerchantDao {
		@PersistenceContext
		EntityManager entityManager;
		
		public  Merchant register(Merchant merchant) {
			int i=0;
			Query query=(Query) entityManager.createQuery("from Merchant ");
			ArrayList<Merchant> al=(ArrayList<Merchant>) query.list();
			
			for(Merchant m:al) {
				if (m.getMerchantEmail().equals(merchant.getMerchantEmail())) {
					i=1;
					break;
					
				}				
			}
			if(i==0) {
				entityManager.persist(merchant);
				return merchant;
			}
			else{
				return null;
			}
			
			}

		@Override
		public Merchant addMerchant(int merchantId) {
			
			
				Query query = (Query) entityManager.createQuery("update Merchant set approval_status = :status where merchant_id= :id");
				query.setParameter("status", "Active");
				query.setParameter("id", merchantId);
				query.executeUpdate();

			return entityManager.find(Merchant.class, merchantId);
		}

		@Override
		public Merchant removeMerchant(int merchantId) {
			Merchant m = entityManager.find(Merchant.class, merchantId);
			entityManager.remove(m);
			return entityManager.find(Merchant.class, merchantId);
		}

		@Override
		public ArrayList<Merchant> getByInactive() {
			Query query=(Query) entityManager.createQuery("from Merchant ");
			ArrayList<Merchant> al=(ArrayList<Merchant>) query.list();
			return al;

		}

		@Override
		public Merchant addByAdmin(Merchant merchant) {
			
			
			int i=0;
		
			
			Query query=(Query) entityManager.createQuery("from Merchant ");
			ArrayList<Merchant> al=(ArrayList<Merchant>) query.list();
			
			for(Merchant m:al) {
				if (m.getMerchantEmail().equals(merchant.getMerchantEmail())) {
					i=1;
					break;
					
				}				
			}
			if(i==0) {
				entityManager.persist(merchant);
				return merchant;
			}
			else{
				return null;
			}
			
		
		}
	}

