package com.ssafy.model.dto;

import java.io.Serializable;

public class Product implements Serializable{

	private int productno;
	private String name;
	private int price;
	private String info;
	
	public int getProductno() {
		return productno;
	}
	public void setProductno(int productno) {
		this.productno = productno;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public Product(int productno, String name, int price, String info) {
		super();
		this.productno = productno;
		this.name = name;
		this.price = price;
		this.info = info;
	}
	
	@Override
	public String toString() {
		return "ProductDto [productno=" + productno + ", name=" + name + ", price=" + price + ", info=" + info + "]";
	}
	
}
