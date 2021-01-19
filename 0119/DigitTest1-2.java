package com.ssafy.algo;

import java.util.Scanner;
/**
 * @author youn
 * @Comment 두번째로 짠 코드입니다. 처음에 짠 알고리즘을 수정 보완하여 더 완벽하게 구현했습니다.
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
		int[] count = new int[10];
		while(true) {
			int num = scan.nextInt();
			if(num==0) break;
			decimalCount(num,count);
		}
		for (int i = 0; i < count.length; i++) {
			if(count[i] != 0) System.out.println(i+" : "+count[i]+"개");
		}
		
	}

}
