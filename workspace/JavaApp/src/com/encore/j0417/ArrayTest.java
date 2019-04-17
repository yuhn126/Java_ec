package com.encore.j0417;

public class ArrayTest {

	public static void main(String[] args) {
		// 1. 배열 선언과 초기화
		int []su = { 1,2,3,4,5 };		// 반드시 선언과 초기화를 함께 기술!
		
		System.out.println("su[0]번지 : " + su[0]);
		System.out.println("su[1]번지 : " + su[1]);
		System.out.println("su[2]번지 : " + su[2]);
		System.out.println("su[3]번지 : " + su[3]);
		System.out.println("su[4]번지 : " + su[4]);
//		System.out.println("su[5]번지 : " + su[5]);		
//		인덱스 : 0~4를 벗어남.
		System.out.println("=======================");
		System.out.println("배열의 크기(요소갯수) : " + su.length);
		
		for(int i = 0; i < su.length; i++) {
			System.out.println("su[" + i + "]번지 : " + su[i] );
		}
		
		System.out.println("=======================");
		
		int [][]su2 = { { 1, 2, 3 } , { 4, 5, 6, 7 } };
		
//		전체 데이터 조회
		for(int i = 0; i < su2.length; i++) {	// 행 인덱스 i = 0, 1
			for (int j = 0; j < su2[i].length; j++) {
				System.out.println("su2[" + i + "][" + j + "]번지 : " + su2[i][j] );
			}
		}

	}

}
