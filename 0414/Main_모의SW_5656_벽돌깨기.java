package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_모의SW_5656_벽돌깨기 {
	
	static int N,W,H,answer;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int list[];
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			answer = Integer.MAX_VALUE;
			
			map = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			list = new int[N];
			permutation(0,list);
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	private static void permutation(int cnt, int[] list) {
		
		if(cnt == N) {
			answer = Math.min(answer, breakBrick(list));
			return;
		}
		
		for (int i = 0; i < W; i++) {
			list[cnt] = i;
			permutation(cnt+1,list);
		}
		
	}

	private static int breakBrick(int[] list) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean visited[][] = new boolean[H][W];

		int temp[][] = new int[H][W];
		for (int i = 0; i < H; i++) { // 배열 복사
			for (int j = 0; j < W; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		for (int num = 0; num < N; num++) { // 구슬의 개수만큼 for문
			int c = list[num];
			for (int i = 0; i < H; i++) {
				if(temp[i][c] != 0) {
					queue.add(new int[] {i,c});
					break;
				}
			}
			
			while(!queue.isEmpty()) {
				int tmp[] = queue.poll();
				int row = tmp[0];
				int col = tmp[1];
				int range = temp[row][col]-1;
				int nr,nc;
				temp[row][col] = 0; // 벽돌 제거
				visited[row][col] = false;
				if(range ==0) continue;
				for (int i = 0; i < 4; i++) {
					for (int j = 1; j <= range; j++) {
						nr = row + dr[i]*j;
						nc = col + dc[i]*j;
						if(nr>-1 && nr<H && nc>-1 && nc<W && !visited[nr][nc] && temp[nr][nc] != 0) {
							queue.add(new int[] {nr,nc});
							visited[nr][nc] = true;
						}
					}
				}
			}
			// 벽돌 제거 후 정렬
			temp = brickSort(temp);
		}
		int cnt = 0;
		// 남은 벽돌 개수 count
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(temp[i][j] != 0) cnt++;
			}
		}
		return cnt;
	}
	
	private static int[][] brickSort(int[][] temp) {
		Stack<Integer>stack = new Stack<Integer>();
		for (int c=0; c < W; c++) {
			for (int r = 0; r < H; r++) {
				if(temp[r][c] !=0) {
					stack.push(temp[r][c]);
					temp[r][c] =0;
				}
			}
			int size = stack.size();
			int r = H-1;
			for (int i=0; i<size; i++) {
				temp[r--][c] = stack.pop();
			}
		}
		return temp;
	}

}
