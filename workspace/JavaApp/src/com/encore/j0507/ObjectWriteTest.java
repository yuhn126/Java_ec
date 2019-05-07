package com.encore.j0507;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectWriteTest {//객체 쓰기 테스트
	public static void main(String[] args) throws Exception{
		
		FileOutputStream fos = new FileOutputStream("Person.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Person p = new Person();
		
		Person p2 = new Person();
			p2.name = "길라임";
			p2.age = 15;
			p2.job = "학생";
		
		oos.writeObject(p);
		oos.writeObject(p2);
		oos.writeObject("직렬화 안녕!");
		oos.writeInt(300);
		oos.writeBoolean(true);
		
		oos.close();
		fos.close();
		
		System.out.println("객체쓰기 성공!");
	}
}
