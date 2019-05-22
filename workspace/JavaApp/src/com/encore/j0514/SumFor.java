package com.encore.j0514;

import java.util.Scanner;

public class SumFor {
	public static void main(String[] args) {
		int sum = 0;
		System.out.println("1부터 n까지의 합을 구합니다.");
		System.out.print("n의 값 : ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		for(int i = 1; i <= n ; i++) {
			sum += i;
		}
		System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
		
	}
	
}
