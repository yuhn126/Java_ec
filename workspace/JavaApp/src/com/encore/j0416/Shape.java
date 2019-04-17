package com.encore.j0416;

public abstract class Shape {
	
	abstract void draw();		// 선언된 메소드 ==> 자식클래스에게 강제하는 역할
	public void hello() {
		System.out.println("봉쥬르");
	}
}

class Triangle extends Shape{
	@Override
	void draw() {
		System.out.println("삼각형 그리기");
	}
	
}

class Rectangle extends Shape{
	@Override
	void draw() {
		System.out.println("사각형 그리기");
	}
	
}

class Circle extends Shape{
	@Override
	void draw() {
		System.out.println("원 그리기");
	}
	
}
