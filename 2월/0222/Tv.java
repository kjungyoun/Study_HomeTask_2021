package com.ssafy.product.poly;

public class Tv extends Product {
	private int inch;
	private String disPlay;
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		if(inch>-1) this.inch = inch;
		else System.out.println("0보다 큰 인치를 입력하세요");
	}
	public String getDisPlay() {
		return disPlay;
	}
	public void setDisPlay(String disPlay) {
		this.disPlay = disPlay;
	}
	public Tv() {}
	public Tv(int num, String name, int price, int stuck, int inch, String disPlay) {
		super(num, name, price, stuck);
		this.inch = inch;
		this.disPlay = disPlay;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("  inch=").append(inch).append(" disPlay=").append(disPlay);
		return builder.toString();
	}
	
	
	
}
