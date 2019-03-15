package com.maven.dao;

import java.util.List;

import com.maven.entity.Vendor;

public interface VendorDAO {
	List<Vendor> listVendors();
	Vendor getVendor(int Id);
}
