package com.ssafy.algo;

import java.util.Scanner;
/**
 * @author youn
 * @Comment 처음에 짠 코드입니다. DigitTest1-2.java 파일은 해당 코드를 좀 더 정답에 가깝게 수정한 코드입니다.
 */
public class DigitTest1 {
	// 십의 자리수를 판단하여 갯수를 증가시켜주는 메서드
	public static void decimalCount(int num, int count[]) {
		if(num/10 == 0) count[0]++;
		else if(num/10 == 1) count[1]++;
		else if(num/10 == 2) count[2]++;
		else if(num/10 == 3) count[3]++;
		else if(num/10 == 4) count[4]++;
		else if(num/10 == 5) count[5]++;
		else if(num/10 == 6) count[6]++;
		else if(num/10 == 7) count[7]++;
		else if(num/10 == 8) count[8]++;
		else if(num/10 == 9) count[9]++;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] num = new int[100];
		int[] count = new int[10];
		System.out.println("100개 이하로 정수를 입력하시오");
		for (int i = 0; i < num.length; i++) {
			num[i] = scan.nextInt();
			if(num[i]==0) break;
		}
		for (int i = 0; i < num.length; i++) {
			if(num[i]!=0) decimalCount(num[i],count);
			else break;
		}
		for (int i = 0; i < count.length; i++) {
			if(count[i] != 0) System.out.println(i+" : "+count[i]+"개");
		}
		
	}

}
