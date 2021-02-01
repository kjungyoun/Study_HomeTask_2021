package com.java.first;

import java.util.Scanner;

public class ChechPoint {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("키를 입력하세요 : ");
		int height = scan.nextInt();
		System.out.println();
		System.out.print("몸무게를 입력하세요 : ");
		int weight = scan.nextInt();
		System.out.println();
		int bmi = weight + 100 - height;
		System.out.println("비만수치는 "+bmi+"입니다.");
		if (bmi > 0) {
			System.out.println("당신은 비만이군요.");
		}
		
	}

}
