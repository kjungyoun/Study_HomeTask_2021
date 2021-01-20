package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution22 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int AnswerN =0;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/solution22Input.txt"));
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			AnswerN=0;
			int N = scan.nextInt();
			int salt = scan.nextInt();
			map = new int[N][N];
			
			for (int i = 0; i < salt; i++) { // 데이터 입력 저장
				int death = 0; // 죽은 소금쟁이의 수 저장
				int r = scan.nextInt();
				int c = scan.nextInt();
				int dir = scan.nextInt();
				map[r][c] = 1;
				for(int j=3; j>0; j--) { // 소금쟁이 한 마리 세 번 연속 점프
					r += dr[dir-1]*j;
					c += dc[dir-1]*j;
					if(r > -1 && r < N && c > -1 && c < N) { // 배열의 크기를 벗어나지 않았을 때
						if(map[r][c]==1) {
							death++; // 점프한 자리에 소금쟁이가 있을 경우 사망
							break;
						}
						map[r][c] = 1;
						map[r-dr[dir-1]*j][c-dc[dir-1]*j] = 0; // 이전의 위치를 초기화
					}else { // 배열의 크기를 벗어 났을 때
						map[r-dr[dir-1]*j][c-dc[dir-1]*j] = 0; // 이전의 위치를 초기화하고 죽음
						death++;
						break;
					}
				}
				AnswerN += death;
			}
			System.out.println("#"+test_case+" "+(salt - AnswerN));
		}

	}

}
