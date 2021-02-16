package com.ssafy.BOJ;

import java.util.Scanner;

public class Main_B1_2839_김정윤2 {
	/*
	 * 백준 2839 브론즈1 설탕배달
	 */
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		count = 0;
		devide(N);
		System.out.println(count);
	}
	
	public static void devide(int N) {
		if(N==0) {
			return;
		}else if(N<3) {
			count = -1;
			return;
		}
		if((N%5)%3 !=0) {
			if(N%3 == 0) {
				count++;
				devide(N-3);
			}else {
			count++;
			devide(N-5);
			}
		}else {
			count += N/5;
			N %= 5;
			count += N/3;
			devide(N%3);
		}
	}
}
