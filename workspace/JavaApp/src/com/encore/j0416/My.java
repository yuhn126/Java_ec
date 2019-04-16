package com.encore.j0416;

public class My {
	
	int su;		// 멤버변수, 필드 ===> 클래스내의 서로 다른 메소드들이 공유할 데이터!
	public int juwon() {
		// 발생되는 데이터 : 300
		su = 300;
		// 발생된 데이터 주기 ===> 리턴
		return su;
	}
}

class You{
	public int lime(int su) {
		// 주원메소드의 300데이터를 출력
		// 외부에서 데이터 받기 ==> 매개변수
		System.out.println("su = " + su);
		return su;
	}
}
