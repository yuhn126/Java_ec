package com.encore.j0423;

public class PersonTest {
	public static void main(String[] args) {
		//사람 데이터1 : 1, 홍길동, 15, 학생
		//사람 데이터2 : 2, 길라임, 17, 학생
		
		Person p1 = new Person();
			p1.setNo(1);
			p1.setName("홍길동");
			p1.setAge(15);
			p1.setJob("학생");
		
		Person p2 = new Person(0, "길라임", 17, "학생");
//		출력형식 --> 1 : [홍길동, 13, 학생]
		System.out.println(p1.getNo() + " : [" + p1.getName() + ", " + p1.getAge() + ", " + p1.getJob() + "]");

		
//		클래스내의 toString() 메소드란?
		System.out.println("======================");
		System.out.println(p1);
//		p1이 println()메소드 내에 들어가면 p1.toString()이 호출
		System.out.println(p2);
	}
}
