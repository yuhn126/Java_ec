package com.encore.j0820;

interface Menupan{ //공통적인 연결 모듈
	//인터페이스 내의 메소드는 public abstract가 고정됨!
	void 짜장면(); //public fix
	public void 짬뽕();
	public abstract void 볶음밥(); //
}

class Hongkong implements Menupan{

	@Override
	public void 짜장면() {
		System.out.println("달달한 짜장면");
	}

	@Override
	public void 짬뽕() {
		System.out.println("매콤한 짬뽕");
	}

	@Override
	public void 볶음밥() {
		System.out.println("야채듬뿍 볶음밥");
	}
	
}

public class interfaceTest {
	public static void main(String[] args) {
		// A  a1 = new A();
		// A  a2 = new B();
		// A  a2;   a2 = new B();
		//부모			  자식
		
		//Menupan menu = new Menupan(); //인터페이스 또는 추상클래스는 객체화X
		Menupan menu; //인터페이스 또는 추상클래스는 Type선언은 가능
				menu = new Hongkong();		  //객체화는 자식클래스로 (자식은 부모다)로 대체해서 사용!
		menu.짬뽕();
	}
}	
