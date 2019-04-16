package com.encore.j0416;

public class Person {	// 서로 관련있는 속성을 묶는 클래스(자바빈즈)
	private String name;
	private int age;
	private String job;
	
	
	//ctrl + space + enter
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	
	//alt + shift + s ; construct
	public Person(String name, int age, String job) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
	}


	//alt + shift + s
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
}
