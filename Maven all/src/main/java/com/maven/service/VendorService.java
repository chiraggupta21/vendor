package com.maven.service;

import java.util.List;

import com.maven.entity.Vendor;

public interface VendorService {
	List<Vendor> listAllVendors();
	Vendor getVendor(int id);
}
