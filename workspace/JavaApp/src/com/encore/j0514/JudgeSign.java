package com.encore.j0514;

import java.util.Scanner;

public class JudgeSign {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();

		if (num > 0) {
			System.out.println("이 수는 양수입니다.");
		} else if (num < 0) {
			System.out.println("이 수는 음수입니다.");
		} else {
			System.out.println("이 수는 0 입니다.");
		}
		
	}

}
