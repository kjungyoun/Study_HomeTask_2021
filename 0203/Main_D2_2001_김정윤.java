package com.ssafy.SWEA;

import java.util.Scanner;

public class Main_D2_2001_김정윤 {
	static int M,N;
	static int max=0;
	static int [][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			max = 0;
			N = sc.nextInt();
			map = new int[N][N];
			M = sc.nextInt();
			
			// 입력을 받아 배열에 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					killSum(i,j);
				}
			}
			
			System.out.printf("#%d %d\n",test_case,max);
			
		}

	}
	
	public static void killSum(int r, int c) {
		int nr=0,nc=0;
		int sum = 0;
		top:
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				nr = r+i;
				nc = c+j;
				if(nr>=N || nc>=N) {
					sum = 0;
					break top;
				}
				sum += map[nr][nc];
			}
		}
		max = Math.max(max, sum);
	}

}
