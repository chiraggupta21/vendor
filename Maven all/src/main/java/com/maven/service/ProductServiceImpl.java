package com.maven.service;

import java.util.List;

import com.maven.dao.ProductDAO;
import com.maven.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Product service implementation
@Service("pservice")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO prodDAO;

	@Override
	public void saveProduct(Product p) {
		prodDAO.saveProduct(p);
	}

	@Override
	public List<Product> listAllProducts() {
		return prodDAO.listProducts();
	}

	@Override
	public Product getProduct(int id) {
		return prodDAO.getProduct(id);
	}

	@Override
	public void deleteProduct(int id) {
		prodDAO.deleteProduct(id);
	}

}