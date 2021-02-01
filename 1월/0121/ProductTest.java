package com.saffy.object;

public class ProductTest {

	public static void main(String[] args) {
		Ref ref = new Ref(0001, "삼성냉장고",200000,4,150);
		Tv tv = new Tv(0002,"삼성 티비",350000,3,55,"UHD");
		System.out.println(ref);
		System.out.println(tv);
		ref.setPrice(-200);
		ref.setName("LG냉장고");
		System.out.println(ref.getName());
		tv.setStuck(-10);
		tv.setPrice(550000);
		System.out.println(tv.getPrice());
		System.out.println(tv.getDpType());
		
		Ref ref2 = new Ref();
		ref2.setProdNum(0003);
		ref2.setPrice(299000);
		ref2.setName("김치 냉장고");
		ref2.setStuck(16);
		ref2.setVolume(222);
		System.out.println(ref2);
		
		Tv tv2 = new Tv();
		tv2.setProdNum(0004);
		tv2.setName("Sony 티비");
		tv2.setPrice(3499900);
		tv2.setStuck(4);
		tv2.setInch(65);
		tv2.setDpType("WUHD");
		System.out.println(tv2);

	}

}
