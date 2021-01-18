package com.ssafy.basic;

public class DataTypeTest {

	public static void main(String[] args) {
		/* - 정수의 기본 타입은 int형이다. 
		 * - 모든 정수형 숫자는 int이다.
		 * - Byte와 sort는 연산 시 자동으로 int타입으로 형변환 
		 */
		byte b1=10;
		byte b2=5;
		//byte b3 = b1+b2;
		byte b3 = (byte)(b1+b2); // 연산의 결과는 int형으로 자동 형변환되기 때문에 다시 byte로 넣기 위해서는 형변환 해주어야함 
		int i= b1+b2;
		
		// int 범위를 벗어나는 수를 사용할 경우 (l,L)long 형으로 지정 
		// long l = 2222222222;
		long l = 222222222l;
		
		// 정수 / 정수 = 정수
		System.out.println(5/2);
		// 실수 / 실수 or 실수 / 정수 or 정수 / 실수 의 결과가 실
		System.out.println(5/2.0);
		
		float f1 = 65536.2567f;
		System.out.println(f1);
		
		double d1 = 65534.2567;
		System.out.println(d1);

	}

}
