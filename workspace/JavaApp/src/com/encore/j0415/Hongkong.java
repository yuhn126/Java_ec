package com.encore.j0415;

public class Hongkong implements MenuPan {	// 주방
	public void 짬뽕() {
		System.out.println("매콤한 짬뽕");
	}
	
	@Override	//어노테이션 JDK5버전 이후 
	public void 짜장면() {
		System.out.println("달달한 짜장면");
	}
	
	@Override
	public void 볶음밥() {}
	
	public void 초밥() {
		System.out.println("한입에 쏘~옥");
	}
	
}
