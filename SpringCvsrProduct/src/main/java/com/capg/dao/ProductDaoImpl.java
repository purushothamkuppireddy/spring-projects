package com.capg.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import com.capg.model.Product;

@Repository
@EntityScan("com.capg.model")
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	EntityManager entityManager;
	@Override
	public int addProduct(Product product) {
		entityManager.persist(product);
		return 0;
	}

	@Override
	public int updateProduct(Product product) {
		entityManager.merge(product);
		return 0;
	}

	@Override
	public int deleteProduct(int pId) {
		Product product =new Product();
		product.setpId(pId);
//		entityManager.remove(entityManager.contains(product) ? product : entityManager.merge(product));
		entityManager.remove(getByPid(pId));
		return 0;
	}

	@Override
	public Product getByPid(int pId) {
		Product product=entityManager.find(Product.class, pId);
		return product;
	}

	@Override
	public ArrayList<Product> getAll() {
		Query query=(Query) entityManager.createQuery("from Product");
		ArrayList<Product> al=(ArrayList<Product>) query.list();
		return al;
	}

}
