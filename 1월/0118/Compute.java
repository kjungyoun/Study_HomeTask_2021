package com.java.first;

import java.util.Scanner;

public class Compute {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		System.out.println("곱 = "+ (num1*num2));
		System.out.println("몫 = " + (num1/num2));

	}

}
