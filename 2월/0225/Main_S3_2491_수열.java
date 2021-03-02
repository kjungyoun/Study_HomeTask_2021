package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_2491_수열 {
	static int max,N,arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		max = 1;
		up();
		down();
		System.out.println(max);
	}
	
	public static void up() {
		for (int i = 0; i < N; i++) {
			int curr = arr[i];
			int k = i+1;
			int cnt = 1;
			while(k<N) {
				int next = arr[k];
				if(curr <= next) {
					curr = next;
					k++;
					cnt++;
				}else {
					i = k-1;
					break;
				}
				max = Math.max(max, cnt);
			}
		}
	}
	public static void down() {
		for (int i = 0; i < N; i++) {
			int curr = arr[i];
			int k = i+1;
			int cnt = 1;
			while(k<N) {
				int next = arr[k];
				if(curr >= next) {
					curr = next;
					k++;
					cnt++;
				}else {
					i = k-1;
					break;
				}
				max = Math.max(max, cnt);
			}
		}
	}

}
