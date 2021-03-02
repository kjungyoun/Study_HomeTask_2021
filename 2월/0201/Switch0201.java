package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Switch0201 {
	/**
	 * 스위치가 꺼져있으면 키고 켜있으면 끄는 메서드
	 * 
	 * @param arr   스위치 정보 저장한 배열
	 * @param index 스위치의 위치
	 */
	public static void switchOnOff(int arr[], int index) {
		if (arr[index] == 0)
			arr[index] = 1;
		else if (arr[index] == 1)
			arr[index] = 0;
	}

	/**
	 * index를 기준으로 앞뒤 스위치 onoff
	 * 
	 * @param arr   스위치 정보가 저장된 배열
	 * @param index 기준이 되는 index
	 * @param j     스위치의 앞뒤 스위치 좌표
	 */
	public static void switchOnOff(int arr[], int index, int j) {
		if (arr[index - j] == 0) {
			arr[index - j] = arr[index + j] = 1;

		} else if (arr[index - j] == 1) {
			arr[index - j] = arr[index + j] = 0;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); // 전구의 개수
		int arr[] = new int[N + 1];
		arr[0] = 0; // 스위치 위치와 배열의 위치를 맞춰줌
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 학생 수
		int num = Integer.parseInt(in.readLine());
		// 학생 정보를 저장하는 배열
		int student[][] = new int[num][2];
		for (int i = 0; i < student.length; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			student[i][0] = Integer.parseInt(st.nextToken());
			student[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < num; i++) {
			// 남학생일 경우
				if(student[i][0] == 1) { 
					// 스위치의 위치
					int index = student[i][1]; 
					int j = 1;
					while(true) {
						int next = index *j++;
						if(next >= arr.length ) break;
						switchOnOff(arr, next);
					}
//					// 여학생일 경우
			}else if (student[i][0] == 2) {
				// 스위치의 위치
				int index = student[i][1];
				for (int j = 0; j < N; j++) {
					// j가 0이면 현재 자신의 위치의 스위치 onoff
					if (index - j > 0 && index + j < arr.length && arr[index - j] == arr[index + j]) {
						// index-j >0 으로 한 이유는 arr 배열에서 0을 쓰지 않을 것이기 때문
							switchOnOff(arr, index, j);
					}else break;
				}
			}
		}
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0) System.out.println();
		}
	}

}
