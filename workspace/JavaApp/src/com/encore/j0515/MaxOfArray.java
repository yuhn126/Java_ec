package com.encore.j0515;

import java.util.Scanner;

public class MaxOfArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 : ");
		int su = scan.nextInt();
		int[] height = new int[su];
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			System.out.print("height[" + i + "] : ");
			height[i] = scan.nextInt();
			if (max < height[i]) {
				max = height[i];
			}
		}

		
		
		
		
//		for (int i = 0; i < height.length; i++) {
//			System.out.print("height[" + i + "] : ");
//			height[i] = scan.nextInt();
//		}
//		
//		int max = height[0];
//
//		for (int i = 1; i < height.length; i++) { 0번지 들어갈 필요 없당
//			if (max < height[i]) {
//				max = height[i];
//			}
//		}
//		System.out.println("최댓값은 " + max + "입니다.");

		
		
		
		
		
		MaxOfArray m = new MaxOfArray();
		
		for (int i = 0; i < height.length; i++) {
			System.out.print("height[" + i + "] : ");
			height[i] = scan.nextInt();
		}
		
		System.out.println("최댓값은 " + m.maxOf(height) + "입니다.");
		
	}

	public int maxOf(int[] a) {
		int max = a[0];

		for (int i = 1; i < a.length; i++) { // 0번지 들어갈 필요 없당
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}
}
