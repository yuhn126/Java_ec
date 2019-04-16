package com.encore.j0415;

public class ThisTest {
//	한 개의 파일에 두개 이상의  클래스를 정의하는 경우
//	저장 파일명에 해당하는 클래스 앞에만 public과 같은 접은 제한자를 명시할 수 있음
	
	public static void main(String[] args) {
		A a = new A();			// 기본생성자
		System.out.println("기본STR = " + a.str);
		System.out.println("=====================");
		A a2 = new A("파이썬");	// 오버로딩 생성자
		System.out.println("STR = " + a2.str);
	}
}
