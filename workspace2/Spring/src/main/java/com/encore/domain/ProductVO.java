package com.encore.domain;

public class ProductVO {
	String name;
	private double price;
	
	public ProductVO() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductVO(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVO [이름=" + name + ", 가격=" + price + "]";
	}
}
