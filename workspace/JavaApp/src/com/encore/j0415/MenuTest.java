package com.encore.j0415;
//package선언 : 현재 프로그램(클래스)의 위치 지정
//형식) package 상위패키지명.하위패키지명;

import java.io.IOException;
//import선언 : 연재 프로그램(클래스)에서 사용할 욉 클래스의 위치 지정
//형식) import 패키지명.클래스명;

public class MenuTest {
	public static void main(String[] args) throws IOException {
		
		int num;
		int su = 0;		// 증가 또는 감소한 값을 유지하기 위해 반복문 밖에 선언
		do {
			System.out.println("<<메뉴>>");
			System.out.println("1.검색 2.증가 3.감소 4.종료");
			System.out.print("번호--> ");
			
			num = System.in.read()-48;		// 번호 입력
			System.in.read();					// CR(13) 맨 앞으로 이동
			System.in.read();					// LF(10) 줄 바꿈
			System.out.println();
			
			switch(num) {
				case 1: System.out.println("# 검색결과 : " + su);
						break;
				case 2: System.out.println("# 1 증가하였습니다.");
						su += 1;
						break;
				case 3: System.out.println("# 1 감소하였습니다.");
						su -= 1;
			}
			
		}while(num!=4);
		
		System.out.println("--- END ---");
	}
}
