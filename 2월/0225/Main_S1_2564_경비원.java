package com.ssafy.boj;

import java.util.Scanner;

public class Main_S1_2564_경비원 {
	static int N,M,K,sum, store[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		store = new int[K+1][3];
		sum = 0;
		
		for (int i = 0; i < K+1; i++) {
			int dir = sc.nextInt();
			int dis = sc.nextInt();
			setPosition(dir,dis,i);
		}

		for (int i = 0; i < K; i++) {
			go(store[i][0], store[i][1],store[i][2]);
		}
		System.out.print(sum);
	}
	
	// 상점 표시
	public static void setPosition(int dir, int dis, int idx) {
		switch (dir) {
		case 1:
			store[idx][0] = 0;
			store [idx][1] = dis;
			store[idx][2] = dir;
			break;
		case 2:
			store[idx][0] = M;
			store [idx][1] = dis;
			store[idx][2] = dir;
			break;
		case 3 :
			store[idx][0] = dis;
			store [idx][1] = 0;
			store[idx][2] = dir;
			break;
		case 4:
			store[idx][0] = dis;
			store [idx][1] = N;
			store[idx][2] = dir;
			break;
		default:
			break;
		}
	}
	
	public static void go(int dr, int dc, int dir) {
		int r = store[K][0];
		int c = store[K][1];
		int p = store[K][2];
		int length = 0;
		switch (p) {
		case 1:
			if(dir == 2) {
				length = Math.min(c+M+dc, N-c+M+N-dc);
				sum += length;
				return;
			}
			length = Math.abs(r-dr) + Math.abs(c-dc);
			sum += length;
			return;
		case 2:
			if(dir == 1) {
				length = Math.min(c+M+dc, N-c+M+N-dc);
				sum += length;
				return;
			}
			length = Math.abs(r-dr) + Math.abs(c-dc);
			sum += length;
			return;
		case 3 :
			if(dir == 4) {
				length = Math.min(r+N+dr, M-r+N+M-dr);
				sum += length;
				return;
			}
			length = Math.abs(r-dr) + Math.abs(c-dc);
			sum += length;
			return;
		case 4:
			if(dir == 4) {
				length = Math.min(r+N+dr, M-r+N+M-dr);
				sum += length;
				return;
			}
			length = Math.abs(r-dr) + Math.abs(c-dc);
			sum += length;
			return;
		}
		

	}
	

}
