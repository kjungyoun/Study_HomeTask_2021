package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_D4_1223_김정윤 {
	static Stack<String> cal;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = null;
		for (int test_case = 1; test_case <= 10; test_case++) {
			st = new StringBuilder();
			int N = Integer.parseInt(in.readLine());
			// 연산자가 저장된 스택
			Stack<String> save = new Stack<String>();
			// 계산할 피연산자가 저장된 스택
			cal = new Stack<String>();
			String line = in.readLine();
			
			for (int i = 0; i < N; i++) {
				String input = line.valueOf(line.charAt(i));
				if(input.equals("+")) { // + 가 입력되면
					if(save.isEmpty()) save.push(input); // 비어있으면 넣기
					else { // 비어있지 않으면 빌때까지 빼고 넣기
						int size = save.size();
						for (int j = 0; j <=size; j++) {
							if(save.isEmpty()) {
								save.push(input);
								break;
							}
							calculate(save.pop()); // 뺀 연산자는 연산을 위해 calculate 메서드로 보냄
						}
					}
				}else if(input.equals("*")) { // * 가 입력되면
					if(save.isEmpty()) save.push(input); // 비어있으면 넣기
					else { // 비어있지 않을 때 스택의 최상위가 *이면 빼기, +이면 자신을 넣기
						int size = save.size();
						for (int j = 0; j <= size; j++) {
							if(save.isEmpty()) {
								save.push(input);
								break;
							}
							else if(save.peek().equals("*")) { // 스택의 최상위가 *이면
								calculate(save.pop()); // 빼서 연산하기
							}else if(save.peek().equals("+")) { // 스택의 최상위가 + 이면
								save.push(input); // 자신을 넣기
								break;
							}
						}
					}
				}else {
					cal.push(input);
				}
				if(i == N-1) { // 마지막 번째일 경우
					int size = save.size();
					for (int j = 0; j <= size; j++) { // save 스택에 있는 것 전부 빼기
						if(save.isEmpty()) break;
						else {
							calculate(save.pop()); // 빼서 연산하기
						}
					}
				}	
			}
			st.append("#").append(test_case).append(" ").append(cal.pop());
			System.out.println(st.toString());
		}
	}
	/**
	 * 연산자가 입력으로 들어올 경우 연산하는 메서드
	 * 연산자의 종류를 구분하여  cal스택에서 두 개의 피연산자를 pop해서 연산
	 * 연산의 결과를 다시 cal 스택에 push
	 * @param st 전달받은 연산자 종류
	 */
	public static void calculate(String st) {
		if(!cal.isEmpty() && st.equals("+")) {
			int n1 = Integer.parseInt(cal.pop());
			int n2 = Integer.parseInt(cal.pop());
			cal.push(Integer.toString(n1+n2));
		}else if(!cal.isEmpty() && st.equals("*")) {
			int n1 = Integer.parseInt(cal.pop());
			int n2 = Integer.parseInt(cal.pop());
			cal.push(Integer.toString(n1*n2));
		}
	}

}
