package com.encore.j0515;

import java.util.Scanner;

public class TrianglePrint {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int dan;
		System.out.println("왼쪽 아래가 직각인 삼각형을 출력합니다.");
		do {
			System.out.print("몇 단 삼각형입니까? : ");
			dan = scan.nextInt();
			for (int i = 0; i < dan; i++) {//기준 : 행
				for (int j = 0; j <= i; j++) {//기준에 따라 변경되는 값 : 열
					System.out.print("*");
				}System.out.println();
			}
		}while(dan <= 0);
//		}while(반복조건 == 원하지않는데이터입력); 유효성검사 ==> 사용자가 입력한 값이 유효한지 검사
	}
}