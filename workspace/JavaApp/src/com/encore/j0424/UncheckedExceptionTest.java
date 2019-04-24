package com.encore.j0424;

public class UncheckedExceptionTest {

	public static void main(String[] args) {
		//예외발생에 대해서  try~catch문 또는 throws를 사용하지 않고 처리하는 방법
		// ---> RuntimeException의 자식Exception의 경우만 가능
		
		String []names = {"길동", "주원"};	// ---> 배열 인덱스 0, 1 생성
		
		int idx = 1;
		if (idx >= names.length) {
			System.out.println("인덱스를 확인하세요!");
			return;
		}
		
		System.out.println(names[idx]);
	}

}
