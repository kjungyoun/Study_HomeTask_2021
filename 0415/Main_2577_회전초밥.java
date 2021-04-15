package com.ssafy.junol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2577_회전초밥 {
	static int N,d,k,c,answer;
	static int sushi[], list[];
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		list = new int[N];
		sushi = new int[d+1];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(in.readLine());
		}
		
		for (int i = 0; i < k; i++) {
			sushi[list[i]]++;
		}
		int count= getCount();
		
		for (int i = 0; i < N; i++) {
			sushi[list[i]]--;
			// 초밥의 종류가 줄었을 때
			if(sushi[list[i]] == 0) count--;
			// 초밥의 종류가 늘었을 때
			if(sushi[list[(i+k)%N]] == 0) count++;
			sushi[list[(i+k)%N]]++;
			// 초밥 종류가 쿠폰 종류를 포함할 경우 count를 직접 늘려주면 안됨
			if(sushi[c] == 0) answer = Math.max(answer, count+1);
			else answer = Math.max(answer, count);
		}
		System.out.println(answer);
	}
	
	private static int getCount() {
		int count = 0;
		for (int i = 0; i < d+1; i++) {
			if(sushi[i] > 0) count++;
		}
		return count;
	}

}
