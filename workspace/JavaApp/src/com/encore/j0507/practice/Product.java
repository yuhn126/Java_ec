package com.encore.j0507.practice;

import java.io.Serializable;

public class Product implements Serializable{//객체 직렬화 할거임!
	String name;
	int price;
	int stock;

	public Product() {
		
	}
	
	public Product(String name, int price, int stock) {
		
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
