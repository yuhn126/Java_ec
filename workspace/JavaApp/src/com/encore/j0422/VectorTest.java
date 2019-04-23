package com.encore.j0422;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
//		Vector(int initialCapacity, int capacityIncrement)
//		capacityIncrement : 방의 크기, capacityIncrement : 방 크기의 증가치
		
		Vector v = new Vector(5,3);		//벡터 : 데이터를 담는 바구니!
//		데이터 ------> element(요소)
		
		System.out.println("벡터의 용량(방 크기) : " + v.capacity());	//5
		System.out.println("벡터의 요소(입력된 데이터)갯수 : " + v.size()); //0
		
//		벡터는 객체의 참조(a, new A())를 담는 배열
		Integer su = new Integer(1);
		int su2 = 2;
		
		v.addElement(su);
		v.addElement(su2);		//new Integer(2)
		
		System.out.println(v.get(0));
		System.out.println(v.get(1));
		
		for (int i = 3; i < 10; i++) {	//3~9
			//add()는 리턴값이 있고
			//addElement()는 리턴값이 없음.
			v.addElement(i);
		}
		
		System.out.println("벡터의 용량(방 크기) : " + v.capacity());//11
		System.out.println("벡터의 요소(입력된 데이터)갯수 : " + v.size());//9
		
		v.addElement(true);
		v.addElement(3.14);
		v.addElement("자바");
		
		System.out.println("벡터의 용량(방 크기) : " + v.capacity());//14
		System.out.println("벡터의 요소(입력된 데이터)갯수 : " + v.size());//12
		
		// 벡터 안의 데이터 포함 여부
		if(v.contains("자바")) {
			System.out.println("자바를 포함");
		}
		
		System.out.println("================================");
		
//		벡터의 모든 요소 출력
		Enumeration enu = v.elements();
//		Enumeration (열거형 인터페이스) snu = [1,2,3,4,....,"자바"];
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
		
		System.out.println("================================");
		System.out.println("맨 앞의 데이터 : " + v.firstElement());
		System.out.println("맨 뒤의 데이터 : " + v.lastElement());
	}
}
