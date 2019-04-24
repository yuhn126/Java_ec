package com.encore.j0424;

class NestingClass{ //외부클래스
	int i = 11;
	void hello() {
		System.out.println("안녕~!");
		
		//외부클래스에서 내부클래스 자원 사용!	   <=== 체크
		NestedClass nested = new NestedClass();
		nested.print();
	}
	
	class NestedClass{ //내부클래스(Inner클래스)
		int j = 22;
		void print() {
			System.out.println("프린트~!");
		}
		
		//내부클래스에서 외부클래스 자원 사용!
		void callTest() {
			hello();
			System.out.println("i = " + i);
		}
	}//NestedClass
}



//------------------------------------------------------

public class NestedClassTest { //내부클래스에 대한 테스트
	public static void main(String[] args) {
		//외부클래스 - int i, hello(), 내부클래스
		//내부클래스 - int j, print()
		
		NestingClass nesting = new NestingClass();
		nesting.hello(); //외부클래스의 메소드 호출
		System.out.println("========");
		
		//내부클래스의 메소드를 main()에서 직접 호출!
		// --> 객체생성 : 외부클래스명.내부클래스명 참조변수명 = new 생성자().new생성자();
		NestingClass.NestedClass nested = new NestingClass().new NestedClass();
		nested.print();
	}
}
