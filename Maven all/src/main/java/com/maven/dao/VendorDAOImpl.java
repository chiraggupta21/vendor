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

import com.maven.entity.Vendor;

@Repository("vendDAO")
public class VendorDAOImpl implements VendorDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Vendor> listVendors() {
		Session ses = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = ses.getCriteriaBuilder();
		CriteriaQuery<Vendor> cq = cb.createQuery(Vendor.class);
		Root<Vendor> root = cq.from(Vendor.class);
		cq.select(root);
		Query query = ses.createQuery(cq);
		List<Vendor> l = query.getResultList();
		return l;
	}

	@Override
	@Transactional
	public Vendor getVendor(int id) {
		Session ses = sessionFactory.getCurrentSession();
		Vendor v = ses.get(Vendor.class, id);
		return v;
	}
	
}
