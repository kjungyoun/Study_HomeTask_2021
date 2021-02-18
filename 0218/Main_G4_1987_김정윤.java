package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백준 G4 1987 알파벳  Mem : 19920kb , Time : 3444ms
 */
public class Main_G4_1987_김정윤 {
	static char map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int answer,R,C;
	static ArrayList<Character> list = new ArrayList<Character>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) { // 입력 저장
			String line = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		answer = Integer.MIN_VALUE;
		list.add(map[0][0]); // 맨 처음꺼 무조건 삽입
		search(0,0,1);
		System.out.println(answer);
		
	}
	
	public static void search(int r, int c, int cnt) {
		int nr,nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr > -1 && nr < R && nc > -1 && nc < C) {
				if(list.contains(map[nr][nc])) continue;
				// 여기까지 오면 갈 수 있는 칸
				list.add(map[nr][nc]);
				search(nr,nc,cnt+1);
				// 갔던 길 안갔던 걸로 표시
				list.remove(list.size()-1);
			}
		}
		answer = Math.max(answer, cnt);
		return;
	}

}
