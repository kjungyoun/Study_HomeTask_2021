package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_D4_1249_보급로_다익스트라 {
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int map[][] = new int[N][N];
			boolean visited[][] = new boolean[N][N];
			int distance[][] = new int[N][N];
			
			// map에 입력 저장
			for (int i = 0; i < N; i++) {
				String line = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j)-'0';
				}
			}
			
			// distance 배열 초기 값 셋팅
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			
			// 시작점 초기화
			distance[0][0] = 0;
			
			for (int i = 0; i < N*N; i++) { // 정점의 개수만큼 반복
				int min = Integer.MAX_VALUE;
				int minX = -1;
				int minY = -1;
				
				// 최소 비용 경로 찾기
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if(!visited[r][c] && min > distance[r][c]) {
							min = distance[r][c];
							minX = r;
							minY = c;
						}
					}
				}
				
				visited[minX][minY] = true;
				
				int nr,nc;
				// 최소 비용 경로 갱신
				for (int k = 0; k < 4; k++) {
					nr = minX + dr[k];
					nc = minY + dc[k];
					
					if(nr>-1 && nr<N && nc>-1 && nc<N && !visited[nr][nc]
							&& distance[nr][nc] > distance[minX][minY] + map[nr][nc]) {
						distance[nr][nc] = distance[minX][minY] + map[nr][nc];
					}
				}
				
			}
			
			System.out.println("#"+tc+" "+distance[N-1][N-1]);

		} // end for testcase

	} // end for main

}
