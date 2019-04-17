package com.encore.j0416;

public class AbstractTest {
	
	void feel(Shape s) {
//		Shape s = new Shape();   객체 생성 불가
		s.draw();
	}
	
	public static void main(String[] args) {
		AbstractTest at = new AbstractTest();
		at.feel(new Triangle());
		at.feel(new Rectangle());
		at.feel(new Circle());
	}
}
