package com.encore.j0514;

import java.util.Scanner;

public class SumWhile {
	public static void main(String[] args) {
		int sum = 0, i = 1;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("1부터 n까지의 합을 구합니다.");
		System.out.print("n의 값 : ");
		int n = scan.nextInt();

		while (i <= n) {
			sum += i;
			i++;
		}
		System.out.println("1 부터 " + n + "까지의 합은 " + sum + "입니다.");
	}
}
