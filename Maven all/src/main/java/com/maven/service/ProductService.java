package com.maven.service;

import java.util.List;

import com.maven.entity.Product;

//Product service interface
public interface ProductService {
	void saveProduct(Product p);
	Product getProduct(int id);
	void deleteProduct(int id);
	List<Product> listAllProducts();
}
