package com.encore.j0419;

public class StringTest2 {
	public static void main(String[] args) {
		String s1 = "java";
		String s2 = "JaVA";
		
//		★ 문자열 s1, s2를 비교(문자열 내용비교)하시오 ★
		System.out.println("s1.equals(s2) : " + s1.equals(s2));
//		"java".equals("JaVA")	사용 가능.
		
//		대소문자 구분 없이 s1과 s2철자를 비교하시오!
		System.out.println("대문자 변환 : " + s1.toUpperCase()); 	// 전체를 대문자로 (case : 대문자 or 소문자)
		System.out.println("소문자 변환 : " + s2.toLowerCase()); 	// 전체를 소문자로
		
		System.out.println("전체 소문자(s1,s2) 변경 후 비교 : " + s1.toLowerCase().contentEquals(s2.toLowerCase()));	//sql db
		
		System.out.println("대소문자 구분 없이 비교 : " + s1.equalsIgnoreCase(s2));	//java
		
		
		
//		문제) str문자열 안에 있는 숫자의 갯수를 화면에 출력하시오.
//			---> 힌트) 문자열 안의 각 문자들은 인덱스를 갖는다.
		/*
			'0' ---> 48			'a' ---> 97			'A' ---> 65
			'1' ---> 49			'b' ---> 98			'B' ---> 66
			...........			'c' ---> 99			'C' ---> 67
			'9' ---> 57
		*/
		String str = "Java3Pro7gra9mm00ing";		// ---> 화면에 '4'출력
		
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {		// 문자열 str의 전체 인덱스를 표현
			char ch = str.charAt(i);
//			if(ch >= 48 && ch <= 57) {	//숫자의 아스키코드값 (48~57)
			if(ch >= '0' && ch <= '9') {
				cnt++;
			}
		}
		System.out.println("숫자의 갯수 : " + cnt);
	}
}
