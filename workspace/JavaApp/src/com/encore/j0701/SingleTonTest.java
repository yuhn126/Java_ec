package com.encore.j0701;

class A{
	//필드
	//메소드
	private static A instance;//인스턴스 : 특정 클래스 객체
	
	public A() {
		
	}
	
	public static A getInstance() {
		if(instance == null) {//인스턴스가 기본값일때
			instance = new A();
		}
			
		return instance;
	}
}

class B{
	void hello() {}
	static void goodDay() {}
}
//B b = new B();	b.hello();
//B.goodDay();


public class SingleTonTest {
	//특정 클래스에 대해서 한 개의 메모리만 생성해서 공유
	public static void main(String[] args) {
		//static한거만 가져올수있음~~!
		/*
			A a1 = new A();
			A a2 = new A();
			A a3 = new A();
		*/
		
		A a1 = A.getInstance();
		A a2 = A.getInstance();
		A a3 = A.getInstance();
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3.toString());
	}
}

/*
	싱글톤(singleton)방식 ---> 메모리 낭비 방지
	 예) 한 개의 DB서버(DBMS)는 여러명의 사용자(application, 응용프로그램)이 데이터 공유
	 	---> 사용된 Connection(연결 객체)은 바로바로 반환해서 다음 사람(프로그램)이 사용하도록 해야함.
	 	
	 class VendingDAOP{
	 	public void find(){
	 		Connection conn = new Connection();
	 	}	
	 	
	 	public void insert(VO){
	 		Connection conn = new Connection();
	 	}
	 	==> 현재 프로그램에서는 절대 2개 이상의 Connection객체가 생성될 수도 있음.
	 }
	 
	 
=================================================================================================
	 
	 class MyDriverManager{
		static Connection
			if(conn==null){
				conn = new Connection();
			}
		return conn;
	 }
	 
	 
	 class VendingDAO{
	 	public void find(){
	 		Connection conn = MyDriverManager.getConnection();
	 	}	
	 	
	 	public void insert(VO){
	 		Connection conn = MyDriverManager.getConnection();
	 	}
	 	==> 현재 프로그램에서는 절대 2개 이상의 Connection객체가 생성되지 않음.
	 }
	 
 */






