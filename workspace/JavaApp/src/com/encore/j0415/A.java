package com.encore.j0415;

public class A {
//		멤버변수(필드) ---> 기본값 : 0 0.0 false null
		String str;		//클래스 기본값 : null (메모리 할당X)
		
		A(){			//기본 생성자(인자없는 경우)
			this("자바");
			System.out.println("기본생성자");
		}
		A(String str){  // 오버로딩 생성자
			System.out.println("오버로딩 생성자");
			this.str = str;
		  //--------   ---
		  // 멤버변수      지역변수
		}
}
