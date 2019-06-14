package com.encore.j0610;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		//Property : 속성
		Properties pro = new Properties(); //속성 데이터(문자열, text)를 담는 클래스
		
		//데이터 저장(입력)
		//pro.setProperty(String key, String value);
		//key : 저장 또는 검색을 위한 값(유일한 값)		개념) key == 변수명
		//value : 저장하고자 하는 문자열(text)데이터.
		
		pro.setProperty("k1", "길동"); //k1키로 "길동"데이터 저장!
		pro.setProperty("k2", "라임");
		pro.setProperty("k3", "주원");
		
		pro.setProperty("k3", "유신");
		
		//데이터 출력(조회)
		System.out.println("k1 : " + pro.getProperty("k1"));
		System.out.println("k2 : " + pro.getProperty("k2"));
		System.out.println("k3 : " + pro.getProperty("k3"));
		
		System.out.println("=====================");
		//만약 키 값을 모르는 경우?
		
		Enumeration enu = pro.propertyNames();
		//Enumeration : 열거형 인터페이스
		//enu = [k1, k2, k3]
		
		while(enu.hasMoreElements()) {
			Object key = enu.nextElement();
			System.out.println(key + " : " + pro.getProperty(key.toString()));
		}
		
		//test.properties파일로부터 속성데이터 얻어오기!
		/*
		 	<properties파일 작성>
		 	- 형식) 속성이름 = 속성데이터
		 	- 구분자) 서로 다른 속성을 라인으로 구분
		 	- 주의) '=' 보통 등호 앞과 뒤에 공백을 주지않는다.
		*/
		System.out.println("---------------------");
		try {
			pro.load(new FileReader("src/com/encore/j0610/test.properties"));
			//경로 확인!!!
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("name : " + pro.getProperty("name"));
		System.out.println("age : " + pro.getProperty("age"));
		System.out.println("job : " + pro.getProperty("job"));
		System.out.println("etc : " + pro.getProperty("etc"));
	}
	
}
