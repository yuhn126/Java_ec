package p2;

import p1.Parent;

public class Other {
	//자식에서 부모클래스의 메소드 호출
	void callTest() {
		Parent p = new Parent();
		p.m1();
//		p.m2();		에러 발생 : protected는 간은 패키지에서 접근 가능
//		p.m3(); 	에러 발생 : 디폴트(생략)는 같은 패키지에서만 접근 가능
//		p.m4();		에러 발생 : private멤버는 자식도 호출 불가
	}
}
