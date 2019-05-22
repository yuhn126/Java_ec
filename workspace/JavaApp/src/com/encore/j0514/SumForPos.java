package com.encore.j0514;

import java.util.Scanner;

public class SumForPos {
	public static void main(String[] args) {
		int sum = 0;
		int n;
		Scanner scan = new Scanner(System.in);
		System.out.println("1부터 n까지의 합을 계산");
		do {
			System.out.print("n의 값 : ");
			n = scan.nextInt();
		} while (n <= 0);

		for(int i = 1; i <= n ; i++) {
			sum += i;
		}
		System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
	}
}
