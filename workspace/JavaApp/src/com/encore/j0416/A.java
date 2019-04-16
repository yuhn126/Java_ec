package com.encore.j0416;

public class A {
	// 메소드 정의!
	public void hello() {
		System.out.println("A 클래스 안녕~!");
	}
	
	public void m1(int su) {
		System.out.println("m1() : " + su);
	}
	
	public void m2(String name) {
		// main()메소드에 a.m2("나길동"); 실헹되면
		// m2()에서는 String name = "나길동";이 가장 먼저 실행됨.
		System.out.println("m2() : " + name);
	}
	
	public void m3(String name, int age) {
		System.out.println("m3() : " + name + "," + age);
		
	}
	
	public void m4(int su1, int su2, int su3) {
//		su1=10, su2=20, su3=30
		System.out.println("m4() : " + su1 + "," + su2 + "," + su3);
	}
	
	public void m5(int[] arr) {
		System.out.println("m5() : " + arr[0] + "," + arr[1] + "," + arr[2]);
	}
	
	public void m6(String name, int age, String job) {
		System.out.println("m5() : " + name + "," + age + "," + job);
	}
	
	public void m6_2(Person p) {
		System.out.println("m6_2() : " + p.getName() + "," + p.getAge() + "," + p.getJob());
	}
}
