package com.encore.j0415;

public class InterfaceTest {
	public static void main(String[] args) {
	  //손님
		MenuPan menu = new Hongkong();
	  // 부모                                자식
		
		menu.짬뽕();
		menu.짜장면();
		menu.볶음밥();
		
		//static멤버는 클래스명으로 접근!
		System.out.println("코인 값 : " + MenuPan.COIN);
	}
}
