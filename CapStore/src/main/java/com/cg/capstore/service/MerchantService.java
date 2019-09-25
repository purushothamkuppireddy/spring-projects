package com.cg.capstore.service;

import java.util.ArrayList;

import com.cg.capstore.model.Merchant;

public interface MerchantService {
	public  Merchant register(Merchant merchant);

	public Merchant addMerchant(int merchantId);

	public Merchant removeMerchant(int merchantId);

	public ArrayList<Merchant> getByInactive();

	public Merchant addByAdmin(Merchant merchant);
}
