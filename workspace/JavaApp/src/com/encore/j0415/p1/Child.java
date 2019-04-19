package com.encore.j0415.p1;

public class Child extends Parent{
//	자식에서 부모클래스의 메소드 호출
	void callTest() {
		m1();
		m2();
		m3();
//		m4();		에러 발생 : private멤버는 자식도 호출 불가
	}
}
