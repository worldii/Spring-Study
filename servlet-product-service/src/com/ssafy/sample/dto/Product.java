package com.ssafy.sample.dto;

public class Product {
	private String  productCode;
	private String model;
	private int price;
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Product(String productCode, String model, int price) {
		super();
		this.productCode = productCode;
		this.model = model;
		this.price = price;
	}
	
	

}
