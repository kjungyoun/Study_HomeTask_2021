package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_2578_빙고 {
	static int map[][] = new int[5][5];
	static boolean isChecked[][] = new boolean[5][5];
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				remove(Integer.parseInt(st.nextToken()));
				ans++;
				if(check()) {
					System.out.println(ans);
					return;
				}
			}
		}
		
	}
	
	public static void remove(int input) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(map[i][j] == input) {
					isChecked[i][j] = true;
					return;
				}
			}
		}
	}
	
	public static boolean check() {
		count = 0;
		// 가로 열 검사
		top: for (int i = 0; i < 5; i++) {
			
			for (int j = 0; j < 5; j++) {
				if (!isChecked[i][j])
					continue top;
			}
			count++;
		}

		// 세로 열 검사
		top: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (!isChecked[j][i])
					continue top;
			}
			count++;
		}
		
		// 대각선 검사
		boolean bingo = true;
		for (int i = 0; i < 5; i++) {
			if(!isChecked[i][i]) bingo = false;
		}
		if(bingo) count++;
		
		// 대각선 검사 2
		bingo = true;
		for (int i = 0; i < 5; i++) {
			if(!isChecked[i][4-i]) bingo = false;
		}
		if(bingo) count++;
		
		if(count>=3) return true;
		return false;
	}
}
