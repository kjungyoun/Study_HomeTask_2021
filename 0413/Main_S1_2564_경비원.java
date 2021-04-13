package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2564_경비원 {
	
	static class Position{
		int dir, row, col;

		public Position(int dir, int row, int col) {
			super();
			this.dir = dir;
			this.row = row;
			this.col = col;
		}
		
	}
	
	static int C,R,curDir,curR,curC,answer;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(in.readLine());
		
		Position store[] = new Position[N+1];
		
		for (int i = 0; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			int inputDir = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			switch(inputDir) {
			case 1: store[i] = new Position(inputDir,0,val);
					break;
			case 2: store[i] = new Position(inputDir,R,val);
					break;
			case 3: store[i] = new Position(inputDir,val,0);
					break;
			case 4: store[i] = new Position(inputDir,val,C);
					break;
			}
		}
		
		curDir = store[N].dir; //동근이의 방향
		curR = store[N].row;	// 동근이의 x좌표
		curC = store[N].col;	// 동근이의 y좌표
		
		for (int i = 0; i < N; i++) {
			distance(store[i].dir,store[i].row,store[i].col);
		}
		System.out.println(answer);
	}
	
	private static void distance(int dir, int row, int col) {
		int dist = 0;
		switch(curDir) {
		case 1:
			if(dir == 2) {
				dist = Math.min(curC + R + col, C-curC + R + C-col);
			}else {
				dist = Math.abs(curR-row) + Math.abs(curC-col);
			}
			break;
		case 2:
			if(dir == 1) {
				dist = Math.min(curC + R + col, C-curC + R + C-col);
			}else {
				dist = Math.abs(curR-row) + Math.abs(curC-col);
			}
			break;
		case 3:
			if(dir == 4) {
				dist = Math.min(curR + C + row, R-curR + C + R-row);
			}else {
				dist = Math.abs(curR-row) + Math.abs(curC-col);
			}
			break;
		case 4:
			if(dir == 3) {
				dist = Math.min(curR + C + row, R-curR + C + R-row);
			}else {
				dist = Math.abs(curR-row) + Math.abs(curC-col);
			}
			break;
		}
		answer += dist;
		
	}

}
