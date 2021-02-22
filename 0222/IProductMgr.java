package com.ssafy.product.poly;

public interface IProductMgr {
	void add(Product p);
	Product[] searchAll();
	Product searchAllByNum(int num);
	Product[] searchAllByName(String name);
	Product[] searchTv();
	Product[] searchRef();
	Product[] searchByPriceRef();
	Product[] searchByInchTv();
	void update(int num, int price);
	void remove(int num);
	int searchAllPrice();
	void save();
	void load();
}
