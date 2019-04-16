package p1;

public class Other {
	//자식에서 부모클래스의 메소드 호출
	void callTest() {
		Parent p = new Parent();
		p.m1();
		p.m2();
		p.m3();
		//p.m4();		//에러 발생 : private멤버는 자식도 호출 불가
	}
}
