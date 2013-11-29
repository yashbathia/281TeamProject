package com.laptop.pojo;

public class Product {
	
	private int id;
	private String brand;
	private String model;
	private String specification;
	private float price;
	private int qty;
	private int tenantId;
	
	
	public int getTenantId() {
		return tenantId;
	}


	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}


	public Product()
	{}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getSpecification() {
		return specification;
	}


	public void setSpecification(String specification) {
		this.specification = specification;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}

	



}
