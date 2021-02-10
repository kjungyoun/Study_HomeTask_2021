package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_16935_김정윤 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int arr[][]= new int[N][M];
		// 입력 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine());
		int p[][] = arr;
		for (int i = 0; i <= st.countTokens(); i++) {
			int cmd = Integer.parseInt(st.nextToken());
			switch(cmd) {
			case 1: 
				verticalReverse(p);
				continue;
			case 2: 
				horizonReverse(p);
				continue;
			case 3: 
				p = turnRight(p);
				continue;
			case 4: 
				p = turnLeft(p);
				continue;
			case 5: 
				p = moveRightGroup(p);
				continue;
			case 6: 
				p = moveLeftGroup(p);
				continue;
			}
		}
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {
				System.out.print(p[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void verticalReverse(int arr[][]) {
		for (int i = 0; i < arr.length/2; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[arr.length-1-i][j];
				arr[arr.length-1-i][j] = temp;
			}
		}
	}

	public static void horizonReverse(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][arr[i].length-1-j];
				arr[i][arr[i].length-1-j] = temp;
			}
		}
	}
	
	public static int[][] turnRight(int [][] arr) {
		int [][]tempArr= new int[arr[0].length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				tempArr[j][arr.length-1-i] = arr[i][j];
			}
		}
		return tempArr;
	}
	
	public static int[][] turnLeft(int [][] arr){
		int [][]tempArr = new int[arr[0].length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				tempArr[arr[i].length-1-j][i] = arr[i][j];
			}
		}
		return tempArr;
	}
	
	public static int[][] moveRightGroup(int[][]arr){
		int [][]tempArr = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length/2; i++) {
			for (int j = 0; j <arr[i].length/2; j++) {
				tempArr[i][arr[i].length/2+j] = arr[i][j];
			}
		}
		for (int i = 0; i < arr.length/2; i++) {
			for (int j = arr[i].length/2; j < arr[i].length; j++) {
				tempArr[arr.length/2+i][j] = arr[i][j];
			}
		}
		for (int i = arr.length/2; i < arr.length; i++) {
			for (int j = arr[i].length/2; j < arr[i].length; j++) {
				tempArr[i][j-arr[i].length/2] = arr[i][j];
			}
		}
		for (int i = arr.length/2; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length/2; j++) {
				tempArr[i-arr.length/2][j] = arr[i][j];
			}
		}
		return tempArr;
	}
	
	public static int[][] moveLeftGroup(int[][]arr){
		int[][] tempArr = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length/2; i++) {
			for (int j = 0; j <arr[i].length/2; j++) {
				tempArr[arr.length/2+i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < arr.length/2; i++) {
			for (int j = arr[i].length/2; j < arr[i].length; j++) {
				tempArr[i][j-arr[i].length/2] = arr[i][j];
			}
		}
		for (int i = arr.length/2; i < arr.length; i++) {
			for (int j = arr[i].length/2; j < arr[i].length; j++) {
				tempArr[i-arr.length/2][j] = arr[i][j];
			}
		}
		for (int i = arr.length/2; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length/2; j++) {
				tempArr[i][arr[i].length/2+j] = arr[i][j];
			}
		}
		return tempArr;
	}
}
