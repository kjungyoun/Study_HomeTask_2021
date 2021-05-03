package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_D4_5604_구간합 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int num1 = countNum(start); // 시작점의 자리수
			int num2 = countNum(end);	// 끝점의 자리수
			int a[] = new int[10];
			
			for (int i = 1; i < 10; i++) {
				a[i] = i + a[i-1];
			}
			
			long ansStart = 0;
			long ansEnd = 0;
			
			ansStart = (long) ((num1-1) * Math.pow(10, num1-2) * a[9]);
			ansEnd = (long) ((num2-1) * Math.pow(10, num2-2) * a[9]);
			
			ansEnd -= ansStart;
			
		}

	}
	
	private static int countNum(int num) {
		int count = 0;
		while(num>0) {
			num /= 10;
			count++;
		}
		return count;
	}

}
