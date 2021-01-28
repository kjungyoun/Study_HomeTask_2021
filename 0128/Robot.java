package com.beak;

import java.util.Scanner;
/**
 * 백준 : 로봇청소기 (14503)
 * https://www.acmicpc.net/problem/14503
 * @author youn
 *
 */
public class Robot {
	static int[] dr = { -1, 0, 1, 0 }; // ��, ��, ��, ��
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int [][] map = new int [N][M];
		boolean [][] isClean = new boolean[N][M];
		
		// r, c : ���� �κ��� ��ġ , dir : ���� �κ��� ���� ����
		int r = scan.nextInt();
		int c = scan.nextInt();
		int dir = scan.nextInt();
		int nextdir = 0; // ���� ��ġ�� ������ ����
		int nr,nc = 0; // �κ��� ���� ��ġ�� ����
		
		// count : �κ��� û���� ���� ����
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		
		while(true) {
			
			if(!isClean[r][c]) { // �ش� �ڸ��� ������� û��
				isClean[r][c] = true;
				count++;
			}
			
			nextdir = turn(dir); // ���� �ٶ󺸴� ������ ������ ����Ŵ
			nr = r + dr[nextdir];
			nc = c + dc[nextdir];
			
				if(!isClean[nr][nc] && map[nr][nc] != 1) { // �������� �� �� �ְ� ������ ������ ���
					r = nr;
					c = nc;
					dir = nextdir; // ȸ��
					continue; // ó������ ���ư�
					
				}else if(isClean[nr][nc] || map[nr][nc]==1) { // ������ ������ �ʰų� �����ִ� ���
					int sCount = 0; // ���� �����ִ��� ī��Ʈ�ϴ� ����
					
					for (int i = 0; i < 4; i++) { // 4�� Ž��
						nr = r + dr[i];
						nc = c + dc[i];
						if(isClean[nr][nc] || map[nr][nc]==1) sCount++;
					}
					
					if(sCount==4) { // 4���� �����ְų� ������ ���
						nextdir = backward(dir);
						nr = r + dr[nextdir];
						nc = c + dc[nextdir];
						if(map[nr][nc] == 1) break; // �ڰ� ������ ���
						else {
							r = nr;
							c = nc;
							continue;
						}
					}
					
					dir = nextdir; //�ش� ������ ������ ��
					continue;
				}
			
		}
		System.out.println(count);
		

	}

	/**
	 * (0 :��), (1 :��), (2 :��), (3 :��) ���� �����ִ� ���⿡�� �������� �̵�
	 * 
	 * @param dir ���� �����ִ� ����
	 * @return ������ ����
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
	 * (0 :��), (1 :��), (2 :��), (3 :��) ���� ���� �ִ� ���⿡�� �ڷ� ���� ���
	 * 
	 * @param dir ���� ���� ����
	 * @return �ڷ� ���� ����
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
