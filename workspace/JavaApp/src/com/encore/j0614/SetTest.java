package com.encore.j0614;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetTest {
	public static void main(String[] args) {
		// Set : 중복 데이터 제거(유일한 데이터만 저장), (저장되는)순서가 일정치 않다. null허용? O

		//Set<String> set = new HashSet<String>();
		SortedSet<String> set = new TreeSet<String>(); // 정렬된 Set : null허용 ? X
		// 데이터 추가
		set.add("홍길동");
		set.add("길라임");
		set.add("김주원");
		set.add("홍길동");
		set.add("이순신");
		set.add("홍길동");
		//set.add(null);
		//set.add(null);

		System.out.println("Set에 저장된 요소 갯수 : " + set.size());

		// 모든 요소 출력
		Iterator<String> it = set.iterator(); // ---> 모든 데이터 얻어오기
		// 열거형 인터페이스

		while (it.hasNext()) { // ---> it에 열거된 데이터가 존재한다면 true리턴
			System.out.println(it.next()); // 데이터 뽑아오기
		}

		/*
			
		*/

	}
}
