package com.beak;

import java.util.Scanner;

/**
 * 백준 : 로봇청소기 (14503)
 * 
 * @author youn
 *
 */
public class Robot {
	static int[] dr = { -1, 0, 1, 0 }; // 북, 동, 남, 서
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int [][] map = new int [N][M];
		boolean [][] isClean = new boolean[N][M];
		
		// r, c : 현재 로봇의 위치 , dir : 현재 로봇이 보는 방향
		int r = scan.nextInt();
		int c = scan.nextInt();
		int dir = scan.nextInt();
		int nextdir = 0; // 다음 위치를 저장할 변수
		int nr,nc = 0; // 로봇의 다음 위치를 저장
		
		// count : 로봇이 청소한 방의 개수
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		
		while(true) {
			
			if(!isClean[r][c]) { // 해당 자리가 더러우면 청소
				isClean[r][c] = true;
				count++;
			}
			
			nextdir = turn(dir); // 현재 바라보는 방향의 왼쪽을 가리킴
			nr = r + dr[nextdir];
			nc = c + dc[nextdir];
			
				if(!isClean[nr][nc] && map[nr][nc] != 1) { // 왼쪽으로 갈 수 있고 왼쪽이 더러울 경우
					r = nr;
					c = nc;
					dir = nextdir; // 회전
					continue; // 처음으로 돌아감
					
				}else if(isClean[nr][nc] || map[nr][nc]==1) { // 왼쪽이 더럽지 않거나 막혀있는 경우
					int sCount = 0; // 벽이 막혀있는지 카운트하는 변수
					
					for (int i = 0; i < 4; i++) { // 4방 탐색
						nr = r + dr[i];
						nc = c + dc[i];
						if(isClean[nr][nc] || map[nr][nc]==1) sCount++;
					}
					
					if(sCount==4) { // 4방이 막혀있거나 깨끗할 경우
						nextdir = backward(dir);
						nr = r + dr[nextdir];
						nc = c + dc[nextdir];
						if(map[nr][nc] == 1) break; // 뒤가 막혔을 경우
						else {
							r = nr;
							c = nc;
							continue;
						}
					}
					
					dir = nextdir; //해당 방향을 보도록 함
					continue;
				}
			
		}
		System.out.println(count);
		

	}

	/**
	 * (0 :북), (1 :동), (2 :남), (3 :서) 현재 보고있는 방향에서 왼쪽으로 이동
	 * 
	 * @param dir 현재 보고있는 방향
	 * @return 왼쪽의 방향
	 */
	public static int turn(int dir) {
		if (dir == 0)
			return 3;
		else if (dir == 1)
			return 0;
		else if (dir == 2)
			return 1;
		else
			return 2;
	}

	/**
	 * (0 :북), (1 :동), (2 :남), (3 :서) 현재 보고 있는 방향에서 뒤로 가는 기능
	 * 
	 * @param dir 현재 보는 방향
	 * @return 뒤로 가는 방향
	 */
	public static int backward(int dir) {
		if (dir == 0)
			return 2;
		else if (dir == 1)
			return 3;
		else if (dir == 2)
			return 0;
		else
			return 1;
	}

}