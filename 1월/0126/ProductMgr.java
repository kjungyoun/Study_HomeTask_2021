package com.ssafy.product2;

import java.util.Arrays;

public class ProductMgr {
	private Tv[] tvs;
	private Refrigerator[] refs;
	private static ProductMgr instance;
	private int tsize;
	private int rsize;
	private int MAX_SIZE = 100;

	/**
	 * 생성자를 이용한 객체 배열 생성
	 */
	public ProductMgr() {
		tvs = new Tv[MAX_SIZE];
		refs = new Refrigerator[MAX_SIZE];
	}

	/**
	 * tv와 냉장고 객체 정보 저장
	 * 
	 * @param t 티비 객체
	 * @param r 냉장고 객체
	 */
	public void add(Tv t, Refrigerator r) {
		if (tsize < MAX_SIZE)
			tvs[tsize++] = t;
		else if (tsize >= MAX_SIZE)
			System.out.println("TV 목록이 가득찼습니다");
		if (rsize < MAX_SIZE)
			refs[rsize++] = r;
		else if (rsize >= MAX_SIZE)
			System.out.println("냉장고 목록이 가득찼습니다");
	}

	/**
	 * 티비와 냉장고 목록 모두 출력
	 */
	public void searchAll() {
		System.out.println("---------TV목록----------");
		for (int i=0; i<tsize;i++) {
			System.out.println(tvs[i]);
			}
		System.out.println("---------냉장고목록--------");
		for (int i=0; i<rsize;i++)
			System.out.println(refs[i]);
	}

	/**
	 * 상품 번호로 물품 조회
	 * 
	 * @param num 조회할 상품 번호
	 */
	public void searchAllByNum(int num) {
		boolean isFound = false;
		for (int i = 0; i < tsize; i++) {
			if (num == tvs[i].getNum()) {
				isFound = true;
				System.out.println(tvs[i]);
				break;
			}
		}
		if (!isFound) {
			for (int i = 0; i < rsize; i++) {
				if (num == refs[i].getNum()) {
					isFound = true;
					System.out.println(refs[i]);
					break;
				}
			}
		}
		if (!isFound)
			System.out.println("검색 실패!! 제품번호를 확인하세요");
	}

	/**
	 * contains를 이용한 상품명 부분 검색 기능
	 * @param name 검색할 상품명
	 */
	public void searchAllByName(String name) {
		boolean isFound = false;
		for (int i = 0; i < tsize; i++) {
			if (tvs[i].getName().contains(name)) {
				isFound = true;
				System.out.println(tvs[i]);
			}
		}
			for (int i = 0; i < rsize; i++) {
				if (refs[i].getName().contains(name)) {
					isFound = true;
					System.out.println(refs[i]);
				}
			}
		if (!isFound)
			System.out.println("검색 실패!! 제품번호를 확인하세요");
	}
	
	/**
	 * 티비 정보만 검색
	 * @return 티비 객체 배열
	 */
	public Tv[] searchTv() {
		return Arrays.copyOf(tvs, tsize);
	}
	
	/**
	 * 냉장고 정보만 검색
	 * @return 냉장고 객체 배열
	 */
	public Refrigerator[] searchRef() {
		return Arrays.copyOf(refs, rsize);
	}
	
	/**
	 * 상품 번호로 상품 삭제
	 * @param num 삭제할 상품 번호
	 */
	public void remove(int num) {
		boolean isFound = false;
		for (int i = 0; i < tsize; i++) {
			if(num == tvs[i].getNum()) {
				tvs[i] = tvs[tsize-1];
				tvs[tsize-1] = null;
				tsize--;
				isFound = true;
			}
		}
		if(!isFound) {
			for (int i = 0; i < rsize; i++) {
				if(num == refs[i].getNum()) {
					refs[i] = refs[rsize-1];
					refs[rsize-1] = null;
					rsize--;
					isFound = true;
				}
			}
		}
		if(!isFound) System.out.println("삭제 실패!! 제품번호를 확인하세요");
	}
	
	/**
	 * 	전체 재고, 상품 금액을 구하는 기능
	 */
	public int searchAllPrice() {
		int sum=0;
		for(int i=0; i<tsize;i++) {
			sum += tvs[i].getStuck() * tvs[i].getPrice();
		}
		for(int i=0; i<rsize; i++) {
			sum += refs[i].getStuck() * refs[i].getPrice();
		}
		return sum;
	}
}
