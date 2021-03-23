package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		
		int color[][] = new int[N][3]; // 각 집의 최소 비용을 저장하는 배열
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			color[i][0] = Integer.parseInt(st.nextToken());
			color[i][1] = Integer.parseInt(st.nextToken());
			color[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// 현재 선택한 집의 색깔에 이전의 집에서 현재 색과 다른 색 중 최소값과 더함
		for (int i = 1; i < N; i++) {
			color[i][0] += Math.min(color[i-1][1], color[i-1][2]);
			color[i][1] += Math.min(color[i-1][0], color[i-1][2]);
			color[i][2] += Math.min(color[i-1][0], color[i-1][1]);
		}
		
		// 마지막 집에서 3가지 색깔 중 최소 비용의 색깔의 집을 선택
		int answer = Math.min(color[N-1][0], Math.min(color[N-1][1], color[N-1][2]));
		System.out.println(answer);
	}

}
