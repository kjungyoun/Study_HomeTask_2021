package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_2563 {
	static int length =100;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		int [][]arr = new int[100][100];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int j = 0; j <10 ; j++) {
				for (int k = 0; k < 10; k++) {
					arr[r+j][c+k] = 1;
				}
			}
		}
		int count = 0;
		for (int i = 0; i <length; i++) {
			for (int j = 0; j < length; j++) {
				if(arr[i][j]==1) count++;
			}
		}
		System.out.println(count);

	}

}
