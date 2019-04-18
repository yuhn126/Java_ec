package com.encore.j0418;

class B{
//	@Override
//	public String toString() {
//		return "안녕, 비~!!";
//	}
}

public class ToStringTest {
	public static void main(String[] args) {
		B b1 = new B();
		B b2 = new B();
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		
		System.out.println("==============================");
		
		B b3 = new B();
		B b4 = b3;
		System.out.println(b3.toString());
		System.out.println(b4.toString());
		
		System.out.println("b1 : " + b1);
	}
}
