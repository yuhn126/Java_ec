package com.encore.j0418;

public class Car {
//	멤버변수의 기본값 : 정수 - 0, 실수 - 0.0, 논리 - false, 클래스(String) - null, 문자 - '/u0000'
	String carName;
	int wheelNum;
	int velocity;
	
//	c2.equals(c1);
	public boolean equals(Car c) {
		/*
		 * 문자열 내용 비교!!
		 * String s1;  String s2;
		 * 
		 * s1 == s2		 ?
		 * s1.equals(s2) ?
		 * 
		 */
		
		if(this.carName == c.carName && wheelNum == c.wheelNum && velocity == c.velocity) {
			return true;
		}else{
			return false;
		}
	}
	
//	우클 + Source + generate Constructor Using field
	public Car(String carName, int wheelNum, int velocity) {
		super();
		this.carName = carName;
		this.wheelNum = wheelNum;
		this.velocity = velocity;
	}//equals

//	public String toString() {	// to ~ 메소드 : 변환메소드, toString() : 문자열 변환 메소드
//		//---> 객체의 상태를 표현하는 메소드()
//		String str = "이 차는 " + this.carName + "이고 바퀴 수는 " + wheelNum + ", 속도는" + velocity + "입니다";
//		return str;
//	}//toString
	
	


	public static void main(String[] args) {
		Car c1, c2;
		c1 = new Car("소나타", 4, 100);
		c2 = new Car("소나타", 4, 100);
		
		System.out.println(c2.toString());
		
		c2.equals(c1);
		
//		★ c1과 c2를 비교!
//		1. 레퍼런스(참조 == 메모리) 비교
//		2. 내용 비교
		
		
//		레퍼런스 비교? ---> 등가연산자(등호)를 통해 비교!
		if(c1 == c2) {
			System.out.println("레퍼런스(메모리) 같음");
		}else{
			System.out.println("레퍼런스(메모리) 다름");
		}
//		c2 = c1;은 c1이 가리키는 메모리를 c2의 이름으로도 참초한다는 것! (주소 복사)
//		<정리>
//		클래스 참조 변수1 == 클래스 참조 변수2 ----> 메모리 주소 비교!
//		속성변수1 == 속성변수2            ----> 데이터 값 비교!
//		 --> 예) int su1 = 30; int su2 = 30; System.out.println(su1==su2);
		
		if(c1.equals(c2)) {
			System.out.println("객체 내용이 같습니다.");
		}else {
			System.out.println("객체 내용이 다릅니다.");
		}
		
		String result = (c1==c2) ? "레퍼런스 같음" : "레퍼런스 다름";
		System.out.println("결과 : " + result);
		
		
//		Run -> Run Configuration -> argument
//		명령 프롬프트창 : java Car "홍 길동" 주원 300 (공백 : 구분자)
//		==> String arg[] = { "홍 길동", "김 주원" };
		System.out.println("메인 전달 데이터 갯수 -->" + args.length);
	    for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] : " + args[i]);
		}
	    
	    
//	    System.out.println(args[2] + 300);		//"300"+300 = "300300"
//	    System.out.println(Integer.parseInt(args[2] + 300));		//Integer.parseInt("300")+300 = "600"
//	    parseInt("숫자구성문자열") ---> 숫자문자열을 숫자로 변환하는 기능
//	    					   ---> 큰 따옴표 제거 메소드!
//	    parseInt("300a");	   ---> 에러 : NumberFormatException!
	}
}
