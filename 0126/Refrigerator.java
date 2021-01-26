package com.ssafy.product2;

public class Refrigerator extends Product {
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		if(size>-1) this.size = size;
		else System.out.println("0보다 큰 사이즈를 입력하세요");
	}
	
	public Refrigerator() {}

	public Refrigerator(int num, String name, int price, int stuck, int size) {
		super(num, name, price, stuck);
		this.size = size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("  size=").append(size);
		return builder.toString();
	}
	
	
}
