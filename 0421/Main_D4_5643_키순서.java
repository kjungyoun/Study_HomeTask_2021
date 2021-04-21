package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_D4_5643_키순서 {
	
	static int N,M;
	static int[] student;
	static boolean[][] adjMatrix;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			
			student = new int[N+1]; // 자신을 제외한 다른 애들의 키정보 수
			adjMatrix = new boolean[N+1][N+1];
			int ans = 0;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[from][to] = true; // 인접행렬 생성
			}
			
			for (int i = 1; i <=N; i++) { // 각 정점에서 bfs 시도
				bfs(i);
			}
			
			for (int cnt : student) { // 자신을 제외한 다른애들의 정보를 아는애 count
				if(cnt >= N-1)
					ans++;
			}
			
			System.out.println("#"+tc+" "+ans);
		}

	}
	
	private static void bfs(int start) {
		Queue<Integer>queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[N+1];
		queue.add(start);
		visited[start] = true;
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for (int i = 1; i <=N; i++) {
				if(adjMatrix[curr][i] && !visited[i]) {
					cnt++; // start보다 큰 애들 count
					student[i]++; // i번째의 학생보다 작은 애 count
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		
		student[start] += cnt;
	}

}
