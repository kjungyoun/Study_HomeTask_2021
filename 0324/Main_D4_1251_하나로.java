package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_D4_1251_하나로 {

	static class Edge implements Comparable<Edge>{
		int from,to;
		double weight;
		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Edge [from=").append(from).append(", to=").append(to).append(", weight=").append(weight)
					.append("]");
			return builder.toString();
		}
		@Override
		public int compareTo(Edge o) {
			
			return Double.compare(this.weight, o.weight);
		}	
		
	}
	
	public static void makeSet() {
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}
	}
	
	public static int findSet(int n) {
		if(n == parent[n]) return n;
		return parent[n] = findSet(parent[n]); // compression 진행
	}
	
	public static boolean union(int a, int b){
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA == rootB) return false;
		if(rank[rootA] >= rank[rootB]) {
			parent[rootB] = rootA; // A에 B 연결
			if(rank[rootA] == rank[rootB]) {
				rank[rootA]++;
			}
		}else {
			parent[rootA] = rootB;
		}
		return true;
	}
	
	static int parent[], rank[];
	static int V;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			V = Integer.parseInt(in.readLine());
			int row[] = new int[V]; // x 좌표 저장 배열
			int col[] = new int[V]; // y 좌표 저장 배열
			parent = new int [V];
			rank = new int[V];
			
			
			
			st= new StringTokenizer(in.readLine());
			for (int i = 0; i < V; i++) { // x좌표 저장
				row[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(in.readLine()); // y좌표 저장
			for (int i = 0; i < V; i++) {
				col[i] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(in.readLine()); // 환경 부담 세율
			
			int edgeNum = V*(V-1)/2; // 간선의 총 개수
			
			Edge edgeList[] = new Edge[edgeNum]; // 간선 리스트 선언
			
			int k = 0;
			
			ex: while(true) { // 간선 리스트에 정보 저장
				for (int i = 0; i < V-1; i++) {
					for (int j = i+1; j < V; j++) {
						if(k == edgeNum) break ex;
						double weight = (Math.pow(row[i]-row[j], 2) + Math.pow(col[i] - col[j], 2)) * E;
						edgeList[k++] = new Edge(i, j, weight);
					}
				}
			}
			Arrays.sort(edgeList); // 가중치 순으로 오름차순 정렬
			
			makeSet();
			
			double answer = 0.0;
			for (int i = 0; i < edgeNum; i++) {
				int a = edgeList[i].from;
				int b = edgeList[i].to;
				double weight = edgeList[i].weight;
				if(union(a,b)) {
					answer += weight;
				}
			}
			System.out.println("#"+tc+" "+Math.round(answer));
		}
	}

}
