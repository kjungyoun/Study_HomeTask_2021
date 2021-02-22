package com.ssafy.product.poly;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgrImpl mgr = new ProductMgrImpl();
		
		
		mgr.add(new Tv(1000,"삼성tv",2000000,4,50,"QHD"));
		mgr.add(new Tv(2000,"LG tv",2300000,8,40,"UHD"));
		mgr.add(new Tv(3000,"애플tv",1990000,7,55,"WUHD"));
		mgr.add(new Tv(4000,"소니tv",5600000,10,60,"FHD"));
		mgr.add(new Refrigerator(5000,"삼성냉장고",400000,15,200));
		mgr.add(new Refrigerator(6000,"LG냉장고",543000,8,400));
		mgr.add(new Refrigerator(7000,"김치냉장고",2310000,5,100));
		mgr.add(new Refrigerator(8000,"애플냉장고",876000,3,400));
		
		System.out.println("=============전체검색=============");
		Product[] prods = mgr.searchAll();
		for(Product p : prods)
			System.out.println(p);
		System.out.println("=============제품번호로 검색=============");
		System.out.println(mgr.searchAllByNum(3000));
		System.out.println(mgr.searchAllByNum(9000));
		System.out.println(mgr.searchAllByNum(7000));
		System.out.println("=============이름으로 검색 :애플=============");
		prods = mgr.searchAllByName("애플");
		for(Product p : prods)
			System.out.println(p);
		System.out.println("=============이름으로 검색 :삼성=============");
		prods = mgr.searchAllByName("삼성");
		for(Product p : prods)
			System.out.println(p);
		System.out.println("=============TV정보만 검색=============");
		prods = mgr.searchTv();
		for(Product p : prods) System.out.println(p);
		System.out.println("=============냉장고정보만 검색=============");
		prods = mgr.searchRef();
		for(Product p : prods) System.out.println(p);
		System.out.println("=============정보 수정=============");
		mgr.update(2000, 9999999);
		mgr.update(6000, 12341234);
		System.out.println("=============전체검색=============");
		prods = mgr.searchAll();
		for(Product p : prods)
			System.out.println(p);
		System.out.println("=============정보 삭제=============");
		mgr.remove(2000);
		mgr.remove(8000);
		System.out.println("=============전체검색=============");
		prods = mgr.searchAll();
		for(Product p : prods)
			System.out.println(p);
		System.out.println("=============재고,가격정보=============");
		System.out.println("전체 상품의 가격의 합: "+mgr.searchAllPrice() + "원");
		
		mgr.save();
	}

}
