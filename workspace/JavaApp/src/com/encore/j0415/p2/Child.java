package com.encore.j0415.p2;

import com.encore.j0415.p1.Parent;

public class Child extends Parent {
	//자식에서 부모클래스의 메소드 호출
	void callTest() {
		m1();
		m2();	// protected인 메소드 : 같은 패키지에서 접근 가능
				// 상속관계에 있는 자식클래스는 다른 패키지라도 접근 가능!
//		m3();	에러 발생 : 디폴트(생략)는 같은 패키지에서만 접근 가능
//		m4();	에러 발생 : p
	}
}
