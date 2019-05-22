package com.encore.j0514;

import java.util.Scanner;

public class MaxValuePrint {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("세 정수의 최댓값을 구합니다");
		
		int []inte = new int[3];
		System.out.print("a의 값 : ");
		inte[0] = scan.nextInt();
		System.out.print("b의 값 : ");
		inte[1] = scan.nextInt();
		System.out.print("c의 값 : ");
		inte[2] = scan.nextInt();
		
		int max = inte[0];

		for (int i = 0; i < inte.length; i++) {
			if( max < inte[i]) {
				max = inte[i];
			}
		}
		System.out.println("최댓값은 " + max + "입니다.");
	}

}
