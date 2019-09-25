package com.cg.capstore.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capstore.dao.MerchantDao;
import com.cg.capstore.model.Merchant;

@Transactional
@Service
public class MerchantServiceImpl implements MerchantService {
	
	
		@Autowired
		MerchantDao dao;
		
	public  Merchant register(Merchant merchant) {

			return dao.register(merchant);
		}

	@Override
	public Merchant addMerchant(int merchantId) {
	
		return dao.addMerchant(merchantId);
	}

	@Override
	public Merchant removeMerchant(int merchantId) {
		
		return dao.removeMerchant(merchantId);
	}

	@Override
	public ArrayList<Merchant> getByInactive() {
		
		return dao.getByInactive();
	}

	@Override
	public Merchant addByAdmin(Merchant merchant) {
		
		return dao.addByAdmin(merchant);
	}
	}

