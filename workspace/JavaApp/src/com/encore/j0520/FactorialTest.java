package com.encore.j0520;

import java.util.Scanner;

public class FactorialTest {

	int factorial(int n) {
		if (n > 0)
			return n * factorial(n - 1);// 재귀호출
		else
			return 1;// 종료조건 (되돌아 오기 가능)
	}// factorial

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("1이상의 정수를 입력하세요: ");
		int n = scan.nextInt();
		FactorialTest ft = new FactorialTest();
		System.out.println(n + "의 팩토리얼 값은 " + ft.factorial(n) + "입니다.");
	}// main
}
