package com.ssafy.product;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ProductMgr mgr = ProductMgr.getInstance();
		while(true) {
			System.out.println("---------------------------------");
			System.out.println("\t 사용자 메뉴 \t");
			System.out.println("0 입력 : 종료");
			System.out.println("1 입력 : 상품을 추가하기");
			System.out.println("2 입력 : 저장된 상품 모두 출력");
			System.out.println("3 입력 : 상품 번호로 검색");
			System.out.println("4 입력 : 상품 번호로 삭제");
			System.out.println("5 입력 : 특정 가격 이하의 상품만 검색");
			System.out.println("---------------------------------");
			System.out.println("사용할 기능의 숫자를 입력해주세요. : ");
			int N = scan.nextInt();
			if(N == 1) {
				System.out.println("---------------------------------");
				System.out.println("저장할 상품 번호를 입력하세요 : ");
				int num = scan.nextInt();
				System.out.println("저장할 상품 이름을 입력하세요 : ");
				String name = scan.next();
				scan.nextLine();
				System.out.println("저장할 상품 가격을 입력하세요 : ");
				int price = scan.nextInt();
				System.out.println("저장할 상품 수량을 입력하세요 : ");
				int stuck = scan.nextInt();
				mgr.add(new Product(num, name, price, stuck));
				System.out.println("저장되었습니다.");
			}else if(N == 2) {
				System.out.println("---------------------------------");
				mgr.list();
			}else if(N == 3) {
				System.out.println("---------------------------------");
				System.out.println("검색할 상품의 상품 번호를 입력하세요 : ");
				int num = scan.nextInt();
				mgr.list(num);
			}else if(N == 4) {
				System.out.println("---------------------------------");
				System.out.println("삭제할 상품의 상품 번호를 입력하세요");
				int num = scan.nextInt();
				mgr.delete(num);
				System.out.println("삭제 되었습니다.");
			}
			else if(N == 5) {
				System.out.println("---------------------------------");
				System.out.println("검색할 기준 가격을 입력하세요 : ");
				int price = scan.nextInt();
				mgr.priceList(price);
			}else if(N == 0) break;
			else System.out.println("0~4사이의 숫자만 입력하세요");
		}
		
		System.out.println("종료되었습니다.");
	}

}
