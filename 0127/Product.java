package com.saffy.product.poly;

public class Product {
	private int num;
	private String name;
	private int price;
	private int stuck;
	public Product() {}
	public Product(int num, String name, int price, int stuck) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.stuck = stuck;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
		if(price>-1) this.price = price;
		else System.out.println("0이상의 가격을 입력하세요");
	}
	public int getStuck() {
		return stuck;
	}
	public void setStuck(int stuck) {
		if(stuck >-1) this.stuck = stuck;
		else System.out.println("0이상의 재고를 입력하시오");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("num=").append(num).append(" name=").append(name).append(" price=").append(price)
				.append(" stuck=").append(stuck);
		return builder.toString();
	}
	
	
	
}
