package com.encore.j0516;

import java.util.Scanner;

public class DayOfYear {
	public static int[][] mdays = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 },
			{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int continueWhile = 1;
		do {
			System.out.println("그 해 경과 일 수를 구합니다.");
			System.out.print("년 : ");
			int year = scan.nextInt();
			System.out.print("월 : ");
			int month = scan.nextInt();
			System.out.print("일 : ");
			int date = scan.nextInt();

			int isLeap = isLeapM(year);// 윤년 1, 평년 0 리턴
			int addDate = dayOfYear(month);
			int dayYear = 0;
			
			if(month < 2) {
				isLeap = 0;
			}
			dayYear = isLeap + addDate + date;
	

			System.out.println("그 해 " + dayYear + "일 째 입니다.");
			System.out.print("한 번 더 할까요? (1.예/0.아니오) : ");
			continueWhile = scan.nextInt();
		} while (continueWhile == 1);

	}

	public static int isLeapM(int year) {
//		//static 안붙일라면 메인에서 생성하삼
//		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
//			return 1;
//		} else {
//			return 0;
//		}
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? 1 : 0;
	}

	public static int dayOfYear(int m) {
		int addDate = 0;
		for (int i = 0; i < m - 1; i++) {
			addDate += mdays[1][i];
		}
		return addDate;
	}
}
