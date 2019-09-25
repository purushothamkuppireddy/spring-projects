package com.capg.dao;

import java.util.ArrayList;

import com.capg.model.Product;

public interface ProductDao {

	int addProduct(Product product);
	int updateProduct(Product product);
	int deleteProduct(int pId);
	Product getByPid(int pId);
	ArrayList<Product> getAll();
}
