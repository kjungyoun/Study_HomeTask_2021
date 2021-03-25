package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_9205_맥주마시면서걸어가기 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine())+2; // 정점 개수
			StringTokenizer st = null;
			int row[] = new int[N];
			int col[] = new int[N];
			boolean LIS[][] = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				row[i] = Integer.parseInt(st.nextToken());
				col[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) { // 초기값 셋팅
				for (int j = 0; j < N; j++) {
					int dist = Math.abs(row[i]-row[j]) + Math.abs(col[i]-col[j]);
					LIS[i][j] = dist > 1000 ? false : true;
				}
			}
			
			// 플로이드-워샬
			for (int k = 0; k < N; k++) {	// 경유지
				for (int i = 0; i < N; i++) {	// 출발지
					for (int j = 0; j < N; j++) {	// 도착지
						if(LIS[i][k] & LIS[k][j]) {
							LIS[i][j] = LIS[i][k] & LIS[k][j];
						}
					}
				}
			}
			System.out.println((LIS[0][N-1] ? "happy" : "sad"));
		}

	}

}
