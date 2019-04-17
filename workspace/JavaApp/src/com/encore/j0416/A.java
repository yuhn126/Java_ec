package com.encore.j0416;

public class A {
	// 메소드 정의!
	public void hello() {
		System.out.println("A 클래스 안녕~!");
	}
	
	////////////////////////////////////////////////////////
	// <메소드 파라미터 테스트>(m1 ~ m6)					      //
	// - 메소드 실행에 필요한 데이터를 외부에서 전달 받기 위해 매개변수 선언  //
	// - 메소드에서 가장 먼저 실행								  //
	////////////////////////////////////////////////////////
	
	
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
		System.out.println("m6() : " + name + "," + age + "," + job);
	}
	
	public void m6_2(Person p) {
		System.out.println("m6_2() : " + p.getName() + "," + p.getAge() + "," + p.getJob());
//		메소드 끝 괄호 전에는 반드시 return;문이 위치해야함!
//		단, 결과 데이터가 없을 때(return데이터가 없을때)는 생략이 가능함.
		return /*데이터*/;
	}
	
	
	
	////////////////////////////////////////////////////////
	// <메소드 리턴데이터 테스트>(m11)					   	      //
	// - 메소드 실행한 결과를 외부에 전달하기 위해 자료형 선언			  //
	// - 메소드에서 가장 마지막에 실행							  //
	////////////////////////////////////////////////////////
	/*
			메소드 끝 문장					리턴자료형
		----------------------------------------------
		 int i  = 300;
		  return "false";			  	 String
		  
		  Abc
	 
	*/
	
	public int m11() {
		System.out.println("m11()");
		int su = 120;
		return su;
	}
	
	public String m12() {
		System.out.println("m12()");
		String name = "김유신";
		return name;
	}
	
	public int[] m13() {	// 리턴형에는 자료형을 한 개 선언!
		int ii = 50;
		int jj = 60;
		int kk = 70;
		
//		return ii, jj, kk;
//		---> 'return'과 ';' 사이에는 데이터가 한개 위치해야 함!!
		
		int []su = { ii, jj, kk };
//		-------- 배열선언
		return su;
	}
	
	public Person m14() {
		System.out.println("m14()");
		String name = "김유신";
		int age = 14;
		String job = "화랑";
		
		Person p = new Person(name, age, job);
		return p;
	}
	
	public My m15() {
		My m = new My();
		
		return m;
	}
	
	public Person[] m16() {
		Person p1 = new Person("김유신",14,"화랑");
		Person p2 = new Person("이순신",25,"장군");
		Person p3 = new Person("홍길동",22,"번쩍");
		
		Person []p = { p1, p2, p3 };
		return p;
	}
	
	
}	// class A
