package com.encore.util;

public class Util {
	public static String toJS(String str) {//파라미터str : 공백을 포함한 문자열
		/*
			System.out.println("\n");//라인변경(줄바꿈)
			System.out.println("\\n");//'\n'을 화면 출력
			//System.out.println(""");//에러발생
			System.out.println("\"");//"(큰따옴표)를 화면 출력
			//System.out.println("\v");//에러발생
			System.out.println("\\v");// \v를 화면출력
		*/
		
		return str.replace("\n", " ")
			     .replace("\r\n"," ")
			     .replace("\\", "\\\\")
			     .replace("\'", "\\\'")
			     .replace("\"", "\\\"");
		//JSON에서 문제가 발생할 수 있는 문자를 변경하는 기능
	}
}
