package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_1260_김정윤_DFS와BFS {
	static int N,start;
	static boolean adjMatrix[][];
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adjMatrix = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		start = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = true;
			adjMatrix[to][from] = true;
		}
		
		dfs(start);
		System.out.println();
		bfs();

	}
	private static void dfs(int start) {
		visited[start] = true;
		System.out.print(start +" ");
		for (int i = 1; i < N+1; i++) {
			if(adjMatrix[start][i] && !visited[i]) {
				dfs(i);
			}
		}	
	}
	
	private static void bfs() {
		boolean visited[] = new boolean[N+1];
		Queue<Integer> queue =  new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			for (int i = 1; i < N+1; i++) {
				if(adjMatrix[current][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}

}
