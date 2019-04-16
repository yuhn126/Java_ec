package com.encore.j0415;

public interface MenuPan {	// 메뉴판
	
	/*public static final*/int COIN=500;
	//final은 유지할 고정값을 명시해야함
	
	//public만 가능
	/* public abstract 고정*/void 짜장면();
	/* public */abstract void 짬뽕();	//선언된 메소드 : abstract method
	public abstract void 볶음밥();	//abstract public void 볶음밥(); 도 문제 X
	
}
