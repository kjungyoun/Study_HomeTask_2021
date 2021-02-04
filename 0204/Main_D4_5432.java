package com.ssafy.swea;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main_D4_5432 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Stack<String> input = new Stack<String>();
		int T = sc.nextInt();
		sc.nextLine();
		for (int test_case = 1; test_case <=T; test_case++) {
			int count = 0;
			String line = sc.nextLine();
			for (int i = 0; i < line.length(); i++) {
				String st = line.valueOf(line.charAt(i));
				if(st.equals("("))
				input.push(st);
				else {
					if(line.valueOf(line.charAt(i-1)).equals("(")) { // 레이저 이면
						input.pop();
						count += input.size();
					}else {
						input.pop();
						count++;
					}
				}
			}
			System.out.printf("#%d %d\n",test_case,count);
		}
	}

}
