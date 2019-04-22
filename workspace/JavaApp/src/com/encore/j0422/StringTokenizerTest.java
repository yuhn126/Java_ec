package com.encore.j0422;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		//StringTokenizer : 문자열 데이터를 특정 구분자(delimiter)를 통해 분리해주는 클래스
		
		//StringTokenizer(String str, String delim)생성자
		//str --> 기준 문자열(전체 문자열), dellim --> 구분자
		//token(토큰) : 분리된 각각의 데이터!
		//공백 무시
		
		String tel = "031--5678";
		StringTokenizer st = new StringTokenizer(tel, "-");
		//st = ["010", "1234", "5678"];

		//토큰 데이터 꺼내오기
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken()); //가져올 토큰 데이터가 없을 시 에러발생!
		
		
		while(st.hasMoreTokens()) {	//st에 토큰데이터를 가지고 있다면 true리턴
			System.out.println(st.nextToken());
		}
		
//		---------------------------------------------------------------------
//		String tel = "010-2322-6754";
//		String[] tel.split(String regex);	: 특정 문자(매개변수)를 통해 데이터를 분리 ---> 결과 : 문자열 배열
//		공백도 데이터로 여김
		System.out.println("===================================================");
//		
//		
		String [] tels = tel.split("-");			//tels = {"010", "1234", "5678"};
		for(int i = 0; i<tels.length; i++) {		//tels배열 인덱스
			System.out.println("tels[" + i + "] = " + tels[i]);
		}
	}//main

}
