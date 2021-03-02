package com.ssafy.product.poly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr{
	private ArrayList <Product> prods;
	
	/**
	 * 생성자를 통해 ArrayList를 이용해 객체 정보 저장
	 */
	public ProductMgrImpl() {
		load();
	}
	
	/**
	 * 제품번호로 ArrayList의 인덱스 찾기
	 * @param num 제품 번호
	 * @return 찾은 인덱스
	 */
	public int findIndex(int num) {
		if(num>-1) {
		for (int i = 0,size=prods.size(); i < size; i++) {
			if(num == prods.get(i).getNum())
				return i;
			}
		}
		return -1; // 못찾았을 경우
		
	}
	
	/**
	 * 상품 객체를 ArrayList에 저장
	 * @param p 저장할 상품 객체
	 */
	public void add(Product p) {
		int pNum = p.getNum();
		int index = findIndex(pNum);
		if(index>-1) { 
			// 제품코드가 이미 존재할 시
			System.out.printf("%d는 중복된 제품코드입니다. 다시 입력하세요",pNum);
		}else prods.add(p);
		save();
	}

	/**
	 * 전체 객체 배열을 리턴
	 */
	public Product[] searchAll() {
		Product[] p = new Product[prods.size()];
		for (int i = 0; i < prods.size(); i++) {
			p[i] = prods.get(i);
		}
		return p;
	}
	
	/**
	 * 상품 번호로 상품 객체 조회
	 * @param num 상품 번호
	 * @return 조회한 상품 객체
	 */
		public Product searchAllByNum(int num) {
		int index = findIndex(num);
		if(index>-1) 
			return prods.get(index);
		else {
			System.out.printf("%d 번호의 제품을 조회할 수 없습니다. 제품번호를 확인하세요",num);
			return null;
		}
	}

	/**
	 * contains를 이용한 상품명 검색 기능 (부분 검색 가능)
	 * @param name 검색할 상품명
	 */
	public Product[] searchAllByName(String name) {
		int count = 0;
		int index = 0;
		for (int i = 0, size=prods.size(); i < size; i++) {
			if(prods.get(i).getName().contains(name)) 
				count++;
		}
		if(count>0) {
			Product[] p = new Product[count];
		for (int i = 0, size=prods.size(); i < size; i++) {
			if(prods.get(i).getName().contains(name)) {
				p[index++] = prods.get(i); 
				}
			}
		return p;
		}else {
			System.out.println("해당 이름의 상품이 존재하지 않습니다.");
			return null;
		}
	}
	
	
	/**
	 * 티비 정보만 검색
	 * @return 티비 객체 배열
	 */
	public Product[] searchTv() {
		int count = 0;
		int index = 0;
		for (int i = 0, size=prods.size(); i < size; i++) {
			if(prods.get(i) instanceof Tv)
				count++;
		}
		if(count>0) {
			Product[] p = new Product[count];
			for (int i = 0, size=prods.size(); i < size; i++) {
				if(prods.get(i) instanceof Tv)
					p[index++] = prods.get(i);
			}
			return p;
		}else {
			System.out.println("TV 상품이 존재하지 않습니다.");
			return null;
		}
	}
	
	/**
	 * 냉장고 정보만 검색
	 * @return 냉장고 객체 배열
	 */
	public Product[] searchRef() {
		int count = 0;
		int index = 0;
		for (int i = 0, size=prods.size(); i < size; i++) {
			if(prods.get(i) instanceof Refrigerator)
				count++;
		}
		if(count>0) {
			Product[] p = new Product[count];
			for (int i = 0, size=prods.size(); i < size; i++) {
				if(prods.get(i) instanceof Refrigerator)
					p[index++] = prods.get(i);
			}
			return p;
		}else {
			System.out.println("냉장고 상품이 존재하지 않습니다.");
			return null;
		}
	}
	
	/**
	 * 400리터 이상의 냉장고 조회 기능
	 */
	public Product[] searchByPriceRef() {
		int count=0;
		int index=0;
		Product[] p = searchRef();
		for (int i = 0; i < p.length; i++) {
			if(p[i].getPrice() >= 400) count++;
		}
		if(count>0) {
			Product[] pro = new Product[count];
			for (int i = 0; i < count; i++) {
				if(p[i].getPrice() >= 400)
					pro[index++] = p[i];
			}
			return pro;
		}else {
			System.out.println("400L이상의 냉장고가 없습니다.");
			return null;
		}
		
	}
	/**
	 * 50인치 이상의 TV 조회 기능
	 */
	public Product[] searchByInchTv() {
		int count=0;
		int index=0;
		Product[] p = searchTv();
		for (int i = 0; i < p.length; i++) {
			if(((Tv)p[i]).getInch() >= 50) count++;
		}
		if(count>0) {
			Product[] pro = new Product[count];
			for (int i = 0; i < count; i++) {
				if(((Tv)p[i]).getInch() >= 50)
					pro[index++] = p[i];
			}
			return pro;
		}else {
			System.out.println("50inch 이상의 TV가 없습니다.");
			return null;
		}
	}
	
	/**
	 * 상품 번호로 상품 삭제
	 * @param num 삭제할 상품 번호
	 */
	public void remove(int num) {
		int index = findIndex(num);
		if(index>-1) prods.remove(index);
		else System.out.println("삭제 실패!! 제품번호를 확인하세요");
	}
	
	/**
	 * 상품번호로 상품 조회하여 가격 수정 기능
	 * @param num 조회할 상품 번호
	 * @param price 수정할 가격
	 */
	public void update(int num, int price) {
		int index = findIndex(num);
		if(index>-1) {
			prods.get(index).setPrice(price);
		}else
			System.out.println("수정 실패! 제품번호를 확인하세요");
	}
	
	/**
	 * 	전체 재고, 상품 금액을 구하는 기능
	 */
	public int searchAllPrice() {
		int sum = 0;
		for (int i = 0,size=prods.size(); i < size; i++) {
			sum += prods.get(i).getStuck() * prods.get(i).getPrice();
		}
		return sum;
	}

	@Override
	public void save() {
		new Thread() {
			public void run() {
				try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("product.dat"))){
					out.writeObject(prods);
				}catch (IOException e) {
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		
	}

	@Override
	public void load() {
		File f = new File("product.dat");
		if(f.exists()) {
			try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))){
				prods = (ArrayList<Product>) in.readObject();
			}catch(IOException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else prods = new ArrayList<Product>();
		
	}
}
