package com.encore.j0614;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.encore.j0502.person.model.Person;

class A{
	void method(Vector v){
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
	}
	void method(ArrayList ar){
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i));
		}
	}
	//-------------------------------------------
	void methodCommon(List list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}

public class ListTest {
	public static void main(String[] args) {
		//java.util.List(인터페이스)
		// ----> 구현클래스 : Vector, ArrayList, LinkedList
		Vector v = new Vector();
		v.add("홍길동");
		v.add("길라임");
		
		A a = new A();
		a.method(v);
		
		ArrayList ar = new ArrayList();
		ar.add("김주원");
		ar.add("김유신");
		a.method(ar);
		
		System.out.println("================");
		
		List v2 = new Vector();
		v2.add(100);
		v2.add(200);
		a.methodCommon(v2);
		
		List ar2 = new ArrayList();
		ar2.add(3000);
		ar2.add(4000);
		a.methodCommon(ar2);
		
		//ArrayList와 Vector는 사용 문법이 같다!
		// ---> 차이점 : ArrayList가 처리 속도가 빠르다
		//		(이유 : Vector에서는 동기화 코드가 추가되어있으므로)
		
		//자료(데이터)에 대한 추가, 검색, 수정, 삭제
		
		System.out.println("================");
		
		Vector<String> v3 = new Vector<String>();
		v3.add("길동");
		v3.add("라임");
		v3.add("주원");
		
		//벡터 toString()오버라이딩을 구현해서 저장된 데이터를 보여줌!
		System.out.println("v3 : " + v3);
		
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("홍");
		alist.add("길");
		alist.add("김");
		
		System.out.println("alist : " + alist);
		
		LinkedList<String> linkList = new LinkedList<String>();
		linkList.add("a");
		linkList.add("b");
		linkList.add("c");
		
		System.out.println("linkList : " + linkList);
		System.out.println("================");
		
		/*
			ArrayList ==> 데이터 1개 저장 : 한 개의 index필요
					 	    만약 데이터의 수가 많고(100000) 첫번째 데이터(인덱스:0)를 삭제할 때
					 	    --> 뒤의 99999데이터는 인덱스를 다시 지정해야함!
			
			LinkedList ==> 데이터 1개 저장 : 한 개의 index, 앞의 데이터 주소, 뒤의 데이터 주소 저장 필요
						    만약 데이터의 수가 많고(100000) 첫번째 데이터(인덱스:0)를 삭제할 때
						    
				201호    202호   203호
			   ["길동" "라임"	(앞 주소 : 201, 뒷 주소 203), "주원" .....]
		
		*/
		
		//ArrayList와 LinkedList 속도 테스트
		ArrayList<Person> list10 = new ArrayList<Person>();
		LinkedList<Person> list20 = new LinkedList<Person>();
		
		//첫번째 : 순차적인 입력!! 데이터를 뒤로 추가
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			list10.add(new Person(1, "홍길동", 15, "학생"));
		}
		long end = System.currentTimeMillis();
		System.out.println("ArrayList10 데이터 입력 시간(순차) : " + (end - start));
		//---------------------------------------------------------------------------------
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			list20.add(new Person(1, "홍길동", 15, "학생"));
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList20 데이터 입력 시간(순차) : " + (end - start));
		
		
		
		System.out.println("=============================================================");
		//두번째 : 중간 입력(ArrayList는 인덱스에 대한 재배열)!!
		//List[]
		//List["길동"]
		//List["주원","길동"]
		//List["길동"]
		ArrayList<Person> list30 = new ArrayList<Person>();
		LinkedList<Person> list40 = new LinkedList<Person>();
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			list30.add(0, new Person(1, "홍길동", 15, "학생"));
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList20 데이터 입력 시간(중간입력) : " + (end - start));
		//---------------------------------------------------------------------------------
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			list40.add(0, new Person(0, "홍길동", 15, "학생"));
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList20 데이터 입력 시간(중간입력) : " + (end - start));
		
		// 결론) 만약, 데이터의 수가 적고 순차적인 저장을 하며 조회 업무를 많이 한다 ---> ArrayList
		//		만약, 데이터의 수가 많고 순차적이지 않은 저장을 하며 삭제 업무를 많이 한다 ---> LinkedList
	}
}
