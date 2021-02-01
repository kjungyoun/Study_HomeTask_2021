package com.saffy.object;

public class Tv {
	private int prodNum;
	private String name;
	private int price;
	private int stuck;
	private int inch;
	private String dpType;
	
	public Tv() {
	}
	public Tv(int prodNum, String name, int price, int stuck, int inch, String dpType) {
		this.prodNum = prodNum;
		this.name = name;
		this.price = price;
		this.stuck = stuck;
		this.inch = inch;
		this.dpType = dpType;
	}
	public int getProdNum() {
		return prodNum;
	}
	public void setProdNum(int productNum) {
		this.prodNum = productNum;
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
		else System.out.println("0보다 큰 가격을 입력하시요.");
	}
	public int getStuck() {
		return stuck;
	}
	public void setStuck(int stuck) {
		if(stuck>-1) this.stuck = stuck;
		else System.out.println("0보다 큰 재고를 입력하시오");
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		if(inch > 0) this.inch = inch;
		else System.out.println("0보다 큰 인치를 입력하시오");
	}
	public String getDpType() {
		return dpType;
	}
	public void setDpType(String dpType) {
		this.dpType = dpType;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("| 제품번호 : ").append(prodNum).append("| 제품명 : ").append(name).append("| 가격 : ")
				.append(price).append("| 재고 : ").append(stuck).append("| 인치 : ").append(inch).append("| 디스플레이 타입 : ")
				.append(dpType).append("]");
		return builder.toString();
	}
	
}
