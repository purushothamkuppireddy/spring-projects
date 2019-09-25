package com.cg.capstore.dao;

import java.util.ArrayList;

import com.cg.capstore.model.Merchant;

public interface MerchantDao {
	public  Merchant register(Merchant merchant);

	public Merchant addMerchant(int merchantId);

	public Merchant removeMerchant(int merchantId);

	public ArrayList<Merchant> getByInactive();

	public Merchant addByAdmin(Merchant merchant);

	
}
