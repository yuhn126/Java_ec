package com.encore.j0416;

public class MethodCallTest {
	public static void main(String[] args) {
		A a = new A();
		a.hello();
		
//		메인 메소드 실행 중 발생 데이터 : 100
		int su = 100;
//		m1() 메소드에게 su를 전달
		
//		a.m1(100);		// 메소드 호출() : ()소괄호 안에 데이터 표시
		a.m1(su);		// 메소드 호출() : ()소괄호 안에 데이터 표시
		
		String name = "나길동";
		a.m2(name);		  // 메소드 호출 시 데이터를 전달할 수 있다!
		
//		데이터 : 15,"길라임" ==> m3()에게 전달
		String name2 = "길라임";
		int age = 15;
//		메소드명(전달할 데이터); <== 메소드 호출
		a.m3("길라임", 15);
		a.m3(name2, age);
//		String name2라는 변수는 m3에 전달되지 않음
//		name2가 담고있는 데이터(value) "길라임"만 전달!
		
//		===========================================================
		
		int i = 10;
		int j = 20;
		int k = 30;
//		m4() 메소드에게 정수값 10,20,30 전달!
		a.m4(i,j,k);
		
//		===========================================================
		
//		11,22,33 세개의 정수를 한개의 이름(변수명)으로 저장 가능?
		int []suArray = { 11, 22, 33 };
		
		a.m5(suArray);
		
//		===========================================================
		
		String name3 = "김주원";
		int age2 = 19;
		String job = "학생";
//		"김주원", 19, "학생" 데이터를 m6()메소드에게 전달  ==> 한 개의 변수명으로 전달
		a.m6("김주원", 19, "학생");
		
//		Person p = new Person();
//		p.setName(name3);
//		p.setAge(age2);
//		p.setJob(job);
//		세개의 데이터가 p라는 한개의 변수명으로 묶여짐.
		
		Person p = new Person(job, age2, job);
//		세개의 데이터가 p라는 한개의 변수명으로 묶여짐.
		a.m6_2(p);
		

		
	}
}
