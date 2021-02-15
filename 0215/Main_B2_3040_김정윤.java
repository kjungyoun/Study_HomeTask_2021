package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2_3040_김정윤 {
	static int N,R;
	static int numbers[],input[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new int[9];
		numbers = new int[7];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(in.readLine());
		}
		combination(0,0);	
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == 7) {
			int sum=0;
			for (int i = 0; i < 7; i++) {
				sum += numbers[i];
			}
			if(sum == 100) {
				for(int x : numbers) {
					System.out.println(x);
				}
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			numbers[cnt] = input[i];
			combination(cnt+1,i+1);
		}
	}
}
