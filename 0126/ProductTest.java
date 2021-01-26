package com.ssafy.product2;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgr mgr = new ProductMgr();
		Tv tv1 = new Tv(1000,"삼성tv",2000000,4,50,"QHD");
		Tv tv2 = new Tv(2000,"LG tv",2300000,8,40,"UHD");
		Tv tv3 = new Tv(3000,"애플tv",1990000,7,55,"WUHD");
		Tv tv4 = new Tv(4000,"소니tv",5600000,10,60,"FHD");
		Refrigerator ref1 = new Refrigerator(5000,"삼성냉장고",400000,15,200);
		Refrigerator ref2 = new Refrigerator(6000,"LG냉장고",543000,8,400);
		Refrigerator ref3 = new Refrigerator(7000,"김치냉장고",2310000,5,100);
		Refrigerator ref4 = new Refrigerator(8000,"애플냉장고",876000,3,400);
		mgr.add(tv1, ref1);
		mgr.add(tv2, ref2);
		mgr.add(tv3, ref3);
		mgr.add(tv4, ref4);
		System.out.println("=============전체검색=============");
		mgr.searchAll();
		System.out.println("=============제품번호로 검색=============");
		mgr.searchAllByNum(3000);
		mgr.searchAllByNum(9000);
		System.out.println("=============이름으로 검색=============");
		mgr.searchAllByName("애플");
		mgr.searchAllByName("김치");
		System.out.println("=============TV정보만 검색=============");
		Tv[] tvs = mgr.searchTv();
		for(Tv t : tvs) System.out.println(t);
		System.out.println("=============냉장고정보만 검색=============");
		Refrigerator[] refs = mgr.searchRef();
		for(Refrigerator r : refs) System.out.println(r);
		System.out.println("=============정보 삭제=============");
		mgr.remove(2000);
		mgr.remove(8000);
		System.out.println("=============재고,가격정보=============");
		System.out.println("전체 상품의 가격의 합: "+mgr.searchAllPrice() + "원");
	}

}
