package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maini_D3_5607_조합 {
	static long P = 1234567891;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			long down = (pactorial(R) * pactorial(N-R)) % P;
			
			long ans = (pactorial(N) * exp(down, P-2))% P;
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	private static long pactorial(int num) {
		long sum = 1;
		
		for (int i = 2; i <= num; i++) {
			sum *= i;
			sum %= P;
		}
		
		return sum;
	}
	
	private static long exp(long x, long y) {
		if(y == 1) return x;
		long r = exp(x,y/2);
		long result = r*r %P;
		
		if(y%2 != 0) {
			result *= x;
			result %= P;
		}
		return result;
	}

}
