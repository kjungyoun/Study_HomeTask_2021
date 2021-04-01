package com.ssafy.junol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1863_김정윤_종교 {
	
	static int N, count;
	static int parents[],rank[];
	
	public static void makeSet() {
		for (int i = 1; i< N; i++) {
			
			parents[i]= i;
		}
	}
	
	public static int findSet(int num) {
		if(parents[num] == num) return num;
		return parents[num] = findSet(parents[num]);
	}
	
	public static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA == rootB) return;
		else {
			// rank를 사용하지 않고 path compression만 사용할 경우
			// findSet에서만 compression이 발생하므로 대표자끼리 union 연산을 진행할 때 compression이 되지않는 경우가 발생
			// 따라서 union 연산에서 Compression을 진행하기 위해 rank 배열 이용
			if(rank[rootA] > rank[rootB]) { // rank 가 더 높은 곳에 자식으로 붙인다.
				parents[rootB] = rootA;
			}else if(rank[rootA] < rank[rootB]) {
				parents[rootA] = rootB;
			}else {
				// 두 곳의 rank가 서로 같다면 아무곳에다가 붙인 후 해당 부모의 rank를 1 증가
				parents[rootB] = rootA;
				rank[rootA]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken())+1;
		int M = Integer.parseInt(st.nextToken());
		
		parents = new int[N];
		rank = new int[N];
		makeSet();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int count = 0;
		for (int i = 1; i < N; i++) {
			int parent = findSet(i);
			if(!list.contains(parent)) {
				count++;
				list.add(parent);
			}
		}
		System.out.println(count);
	}

}
