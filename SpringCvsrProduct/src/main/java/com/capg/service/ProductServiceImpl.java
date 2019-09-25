package com.capg.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.ProductDao;
import com.capg.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired 
	ProductDao productDao;
	@Override
	public int addProduct(Product product) {
		
		return productDao.addProduct(product);
	}

	@Override
	public int updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

	@Override
	public int deleteProduct(int pId) {
		
		return productDao.deleteProduct(pId);
	}

	@Override
	public Product getByPid(int pId) {
		
		return productDao.getByPid(pId);
	}

	@Override
	public ArrayList<Product> getAll() {
		
		return productDao.getAll();
	}

}
