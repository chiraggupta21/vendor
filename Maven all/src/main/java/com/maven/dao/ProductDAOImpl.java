package com.maven.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maven.entity.Product;

//Product CURD implementation
@Repository("prodDAO")
public class ProductDAOImpl implements ProductDAO {
	//Autowire session factory to environment provided reference
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//Save product to database
	@Override
	@Transactional
	public void saveProduct(Product p) {
		Session ses = sessionFactory.getCurrentSession();
		ses.saveOrUpdate(p);
	}
	
	//Fetch products from database
	@Override
	@Transactional
	public List<Product> listProducts() {
		Session ses = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = ses.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> root = cq.from(Product.class);
		cq.select(root);
		Query query = ses.createQuery(cq);
		List<Product> l = query.getResultList();
		return l;
	}

	//Fetch a particular product by id
	@Override
	@Transactional
	public Product getProduct(int id) {
		Session ses = sessionFactory.getCurrentSession();
		Product p = ses.get(Product.class, id);
		return p;
	}

	//Delete product from database
	@Override
	@Transactional
	public void deleteProduct(int id) {
		Session ses = sessionFactory.getCurrentSession();
		Product p = ses.byId(Product.class).load(id);
		ses.delete(p);
	}

}
