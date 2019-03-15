package com.maven.dao;

import java.util.List;

import com.maven.entity.Product;

//Product CURD interface
public interface ProductDAO {
	void saveProduct(Product p);
	List<Product> listProducts();
	Product getProduct(int Id);
	void deleteProduct(int id);
}
