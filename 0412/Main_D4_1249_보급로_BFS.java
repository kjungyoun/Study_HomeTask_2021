package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_D4_1249_보급로_BFS {
	
	static int N,min;
	static int[][] map;
	static boolean [][] visited;
	static int[][] ans;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			ans = new int[N][N];
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(ans[i], Integer.MAX_VALUE);
			}
			
			for (int i = 0; i < N; i++) {
				String line = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j)-'0';
				}
			}
			bfs();
			System.out.println("#"+tc+" "+min);
		} // end for testcase

	} // end for main
		
	
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0,0});
		visited[0][0] = true;
		ans[0][0] = 0;
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			if(r == N-1 && c == N-1) {
				min = Math.min(min, ans[N-1][N-1]);
			}
			int nr,nc;
			
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if(nr>-1 && nr < N && nc>-1 && nc<N ) {
					if(!visited[nr][nc]) {
						visited[nr][nc] = true;
						ans[nr][nc] = ans[r][c] + map[nr][nc];
						queue.offer(new int[] {nr, nc});						
					}else if(visited[nr][nc] && ans[nr][nc] > ans[r][c] + map[nr][nc]) {
						ans[nr][nc] = ans[r][c] + map[nr][nc];
						queue.offer(new int[] {nr, nc});	
					}
				}
			}			
		}
		
	}
	
	

}
