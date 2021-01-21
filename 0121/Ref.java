package com.saffy.object;

public class Ref {
	private int prodNum;
	private String name;
	private int price;
	private int stuck;
	private int volume;
	
	public Ref() {
		
	}
	
	public Ref(int prodNum, String name, int price, int stuck, int volume) {
		this.prodNum = prodNum;
		this.name = name;
		this.price = price;
		this.stuck = stuck;
		this.volume = volume;
	}

	public int getProdNum() {
		return prodNum;
	}

	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
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
		else System.out.println("0보다 큰 가격을 입력하시오");
	}

	public int getStuck() {
		return stuck;
	}

	public void setStuck(int stuck) {
		if(stuck>-1) this.stuck = stuck;
		else System.out.println("0보다 큰 재고를 입력하시오");
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		if(volume>-1) this.volume = volume;
		else System.out.println("0보다 큰 용량을 입력하시오");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("| 제품번호 : ").append(prodNum).append("| 제품명 : ").append(name).append("| 가격 : ").append(price)
				.append("| 재고 : ").append(stuck).append("| 용량 : ").append(volume);
		return builder.toString();
	}
	
}
