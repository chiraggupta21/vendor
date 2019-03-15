package com.maven.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Product table entities
@Entity
@Table(name="prod")
public class Product {
	@Id
	@Column(name="pid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	
	@Column(name="name",length=50)
	private String name;
	
	@Column(name="category",length=50)
	private String category;
	
	@Column(name="description")
	private String desc;
	
	@Column(name="price")
	private float price;
	
	@Column(name="v_id")
	private int vid;

	public Product(int pid, String name , String category, String desc, float price,int vid) {
		this.pid = pid;
		this.name = name ;
		this.category = category;
		this.price = price;
		this.desc=desc;
		this.vid=vid;
	}
	
	public Product(String name, String category, String desc, float price,int vid) {
		this.name = name;
		this.category = category;
		this.desc=desc;
		this.price = price;
		this.vid=vid;
	}
	
	public Product() {
		
	}
	
	//setter and getter
	public int getId() {
		return pid;
	}

	public void setId(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}
}