package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_1992_김정윤 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int map[][] = new int[N][N];
		
		for (int i = 0; i < N; i++) { // 배열에 정보 저장
			String line = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}
		// 실행하는 부분
		pressure(map);
		System.out.println(sb);
		
		

	}
	
	/*
	 * 받은 배열을 4분할하는 메서드
	 */
	public static void divide(int[][] arr) {
		sb.append("(");
		int size = arr.length;
		int [][] ltop = new int[size/2][size/2];
		int [][] rtop = new int[size/2][size/2];
		int [][] lbtm = new int[size/2][size/2];
		int [][] rbtm = new int[size/2][size/2];
		
		for (int i = 0; i < size/2; i++) {
			ltop[i] = Arrays.copyOfRange(arr[i], 0, size/2);
			lbtm[i] = Arrays.copyOfRange(arr[i+size/2], 0, size/2);
			rtop[i] = Arrays.copyOfRange(arr[i], size/2, size);
			rbtm[i] = Arrays.copyOfRange(arr[i+size/2], size/2, size);
		}
		
		pressure(ltop);
		pressure(rtop);
		pressure(lbtm);
		pressure(rbtm);
		sb.append(")");
	}
	
	/*
	 * 받은 배열을 압축하는 메서드
	 */
	public static void pressure(int[][] arr) {
		int sum = 0;
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sum += arr[i][j];
			}
		}
		if(sum == 0) sb.append(0);
		else if(sum == size * size) sb.append(1);
		else divide(arr);
	}

}
