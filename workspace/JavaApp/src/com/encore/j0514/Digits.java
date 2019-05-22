package com.encore.j0514;

import java.util.Scanner;

public class Digits {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("2자리의 정수를 입력하세요.");
		int no;

		do {
			System.out.print("입력 : ");
			no = scan.nextInt();
//		} while ((no < 10) || (no > 99));
		} while (!((no >= 10) && (no <= 99)));

		System.out.println("변수 no의 값은 " + no + "이(가) 되었습니다.");

		scan.close();
	}
}