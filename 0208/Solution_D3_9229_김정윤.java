package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_9229 {
	static int[] weight,snack;
	static int M,max,N,count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= T; test_case++) {
			max = Integer.MIN_VALUE; // 최대 무게 합 저장
			count = 0; // 가져갈 수 있는 방법의 경우의 수 저장
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			weight = new int[N];
			snack = new int[2]; // 뽑은 두 과자봉지를 저장할 배열
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine()," ");
			for (int i = 0; i < N; i++) { // 입력 저장
				weight[i] = Integer.parseInt(st.nextToken());
			}
			combination(0,0);
			if(count == 0) max = -1; // 경우의 수가 없으면 -1 출력
			System.out.println("#"+test_case+" "+max);
		}

	}
	
	public static void combination(int cnt, int start) {
		if(cnt == 2) {
			int weightSum =0;
			for (int i = 0; i < 2; i++) {
				weightSum += snack[i];
			}
				if(weightSum<=M) {
					max = Math.max(max, weightSum);
					count++;
				}
			return;
		}for (int i = start; i < N; i++) {
			snack[cnt] = weight[i]; 
			combination(cnt+1, i+1); // 현재 뽑은 i 의 다음번을 넘김
		}
	}

}
