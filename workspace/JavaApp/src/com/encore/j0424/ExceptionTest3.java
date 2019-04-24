package com.encore.j0424;

//class MyException{
//	
//} 사용자 정의 클래스! MyException Object다!


class MyException extends Exception{
				// is a	  --> 자식은 부모다!
	public MyException(String msg) {
		super(msg);	//부모생성자가 갖는 기능을 실행.
	}
	
}//사용자 정의 예외클래스


public class ExceptionTest3 {
	
	static int su = 100;

	public static void main(String[] args) {
		boolean conditions = true;

		try {
			if (conditions) {
				//throw new MyException("사용자 정의 예외 메세지!");
				
				MyException m = new MyException("사용자 정의 예외 메세지!");
				throw m;
			}
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
