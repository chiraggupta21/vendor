package com.maven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.dao.VendorDAO;
import com.maven.entity.Vendor;

@Service("vservice")
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	private VendorDAO vendDAO;

	@Override
	public List<Vendor> listAllVendors() {
		return vendDAO.listVendors();
	}

	@Override
	public Vendor getVendor(int id) {
		return vendDAO.getVendor(id);
	}

}
