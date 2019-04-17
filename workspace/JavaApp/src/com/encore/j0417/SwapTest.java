package com.encore.j0417;

public class SwapTest {
	// 데이터 교환 테스트
	
	public static void main(String[] args) {
		int su1 = 50;
		int su2 = 30;
		int temp;
		
		// 교환식
		temp = su1;
		su1 = su2;
		su2 = temp;
		
		System.out.println("su1 : " + su1);
		System.out.println("su2 : " + su2);
		
//		-------------------------------------------
		
		int []arr = { 300, 100 };
		
		// 배열의 값 변경	
		 temp = arr[0];
		 arr[0] = arr[1];
		 arr[1] = temp;
		
		System.out.println("arr[0]번지 : " + arr[0]);
		System.out.println("arr[1]번지 : " + arr[1]);
	}
}
