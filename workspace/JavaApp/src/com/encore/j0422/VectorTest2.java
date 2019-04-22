package com.encore.j0422;

import java.util.Vector;

class A{
	void hello() {
		System.out.println("A클래스 안녕~!!");
	}
}

public class VectorTest2 {
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("안녕");		//인덱스 0 부여
		v.add(new A());		//인덱스 1 부여
		
//		get(int index) ---> 데이터 읽기(조회)
//		문제) 벡터 v에 저장된 A클래스의 hello()메소드를 호출하시오.
		Object ob = v.get(1);	//두번쨰 데이터 얻기
//		ob.hello();				//에러발생! --> 부모 참조변수를 통해 자식 호출 불가능
		A a = (A) ob;			//자식클래스 캐스팅
		a.hello();
		
		Vector<String> v2 = new Vector<String>();	//JDK7버전부터 생성자<> 빈 괄호 지원
		v2.add("홍길동");
//		v2.add(new A()); ---> 에러 : 제네릭 사용 시 명시한 String 자료형만 입력할 수 있다.
		
		Vector<A> v3 = new Vector<A>();
		v3.add(new A());	//인덱스 0
		A obj = new A();
		v3.add(obj);		//인덱스 1
		
		System.out.println("==============");
		
//		문제) 벡터 v3에 두번째로 저장된 A클래스의 hello()메소드를 호출하시오.
		A a2 = v3.get(1);	//제네릭을 사용했을때의 이점 : 자식클래스로 캐스팅할 필요가 없음
		a2.hello();
		
		
	/*
	 	<> : 제네릭 타입 --> 어떤 자료형울 사용할 지를 명시(명료성을 높임) : JDK5버전 부터.
	 	
	 	 <E> : element(요소)가 어떤 자료형을 사용할 지 명시.
	 	 <K> : key가 어떤 자료형을 사용할 지 명시.
	 	 <V> : value가 어떤 자료형을 사용할 지 명시.
	 	 <T> : type에 어떤 자료형을 사용할 지 명시.
	 */

	}

}
