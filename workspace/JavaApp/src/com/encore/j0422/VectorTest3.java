package com.encore.j0422;

import java.util.Vector;

public class VectorTest3 {

	public static void main(String[] args) {
//		Vector에 데이터 추가, 삭제, 수정, 검색 하기!
		Vector<String> v = new Vector<>();
		
//		데이터 추가
		v.add("자바");		//인덱스 0
		v.add("SQL");		//인덱스 1
		v.add("HTML");		//인덱스 2
		v.add("JavaScript");//인덱스 3
		v.add("JSP");		//인덱스 4
		v.add("자바");		//인덱스 5
		
//		데이터 삭제
//		v.remove(int index);	
//		v.remove(Object o);		
//		v.remove(0);			//첫번째 데이터 삭제, 빈 자리 없이 앞으로 땡겨짐
		v.remove("자바");		//같은 데이터라도 먼저 저장되어있는 데이터만 삭제
		
//		데이터 수정
//		v.set(int index, Object element);		//element : 변경(대체)할 데이터
//		5번째 데이터를 "자바"를 "자바 프로그래밍"으로 변경!
		v.set(4, "자바프로그래밍");
		
//		데이터 조회
//		System.out.println("다섯번째 데이터 : " + v.get(4));
//		System.out.println("여섯번째 데이터 : " + v.get(5));
//		System.out.println("일곱번째 데이터 : " + v.get(6));		에러발생
//		for (;배열명.length;)			배열의 경우
//		for (;문자열.length();)		문자열의 경우
//		for (;벡터명.size();)			벡터의 경우
		
//		전체 데이터 조회
		for (int i = 0; i < v.size(); i++) {//벡터의 인덱스를 표현
			String str = v.get(i);
			System.out.println("[" + i + "] : " + str);
		}

	}//main

}
