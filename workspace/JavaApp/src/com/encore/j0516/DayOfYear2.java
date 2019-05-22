package com.encore.j0516;

import java.util.Scanner;

public class DayOfYear2 {
	int[][] mdays = { { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년(0행)
			{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };// 윤년(1행)

	int isLeap(int year) {
//		//static 안붙일라면 메인에서 생성하삼
//		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
//		&& 먼저 실행됨
//			return 1;
//		} else {
//			return 0;
//		}
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? 1 : 0;
	}

	int dayOfYear(int y, int m, int d) {
		int sum = d;
		int leap = isLeap(y);

		for (int i = 0; i < m - 1; i++) {
			sum += mdays[leap][i];
		}

		return sum;
	}

	public static void main(String[] args) {
		DayOfYear2 doy = new DayOfYear2();
		Scanner scan = new Scanner(System.in);
		int con;
		do {
			System.out.println("그 해 경과 일 수를 구합니다.");
			System.out.print("년 : ");
			int year = scan.nextInt();
			System.out.print("월 : ");
			int month = scan.nextInt();
			System.out.print("일 : ");
			int date = scan.nextInt();

			int su = doy.dayOfYear(year, month, date);
			System.out.println("그 해 " + su + "일 째 입니다.");
			System.out.print("한 번 더 할까요 ? (1.예/0.아니오) : ");
			con = scan.nextInt();
		} while (con == 1);

	}

}
