package com.ssafy.SWEA;

import java.util.Scanner;

public class Main_D2_1954 {
	// 우, 하,좌,상
	static int dr[] = {0,1,0,-1};
	static int dc[] = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int num = 1;
			int r = 0,c=0,index=0;
			int nr,nc;
			while(true) {
					map[r][c] = num;
					nr = r+dr[index];
					nc = c+dc[index];
					if(num == N*N) break;
					if(nc>=N ||((nc<N && index == 0) && map[nr][nc]!=0)) {
						index = 1;
						continue;
					}else if(nr>=N || ((nr<N && index == 1) && map[nr][nc]!=0)) {
						index = 2;
						continue;
					}else if(nc<= -1|| ((nc>-1 && index == 2) && map[nr][nc]!=0)) {
						index=3;
						continue;
					}else if(nr<= -1|| ((nr>-1 && index == 3) && map[nr][nc]!=0)) {
						index=0;
						continue;
					}
					
					r = nr;
					c = nc;
					num++;
			}
			System.out.printf("#%d\n",test_case);
			for (int i = 0; i < N; i++) {
				for(int x : map[i]) {
					System.out.print(x+" ");
				}
				System.out.println();
			}
		}
	}

}
