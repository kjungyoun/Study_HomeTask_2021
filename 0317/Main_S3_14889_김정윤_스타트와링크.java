package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_14889_김정윤_스타트와링크 {
	static int map[][], N, min;
	static boolean selected[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = null;
		 N = Integer.parseInt(in.readLine());
		 map = new int[N][N];
		 selected = new boolean[N];
		 min = Integer.MAX_VALUE;
		 
		 for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		 
		 combination(0,0);
		 System.out.println(min);
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == N/2) {
			int teamA = 0;
			int teamB = 0;
			for (int i = 0; i < N; i++) {
				if(selected[i]) {
					for (int j = i+1; j < N; j++) {
						if(selected[j]) {
							teamA += map[i][j] + map[j][i];
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				if(!selected[i]) {
					for (int j = i+1; j < N; j++) {
						if(!selected[j]) {
							teamB += map[i][j] + map[j][i];
						}
					}
				}
			}
			min = Math.min(min, Math.abs(teamA-teamB));
			return;
		}
		
		for (int i = start; i < N; i++) {
			selected[i] = true;
			combination(cnt+1, i+1);
			selected[i] = false;
		}
		
	}

}
