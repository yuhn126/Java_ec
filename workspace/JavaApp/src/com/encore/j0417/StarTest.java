package com.encore.j0417;

public class StarTest {

	public static void main(String[] args) {
		for(int i = 0; i < 4; i++) {		// 			1줄 	2줄	 3줄	  4줄
			for(int j = 0; j <= i; j++) {	// 별 출력 :   *   **  ***  ****
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("------");
		
		for(int i = 4; i > 0; i--) {		// 			1줄 	 2줄	  3줄   4줄
			for(int j = 0; j < i; j++) {	// 별 출력 :  ****  ***  **  *
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
