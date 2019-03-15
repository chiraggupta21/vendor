package com.maven.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="vend")
public class Vendor {
	@Id
	@Column(name="v_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="vid",fetch=FetchType.EAGER)
	List<Product> productList;

	public Vendor(int id, String name, List<Product> productList) {
		this.id = id;
		this.name = name;
		this.productList = productList;
	}

	public Vendor(String name, List<Product> productList) {
		this.name = name;
		this.productList = productList;
	}

	public Vendor() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}	
}