class A{
	public void hello(){
		System.out.println("A클래스 안녕");
	}
}

class B{
	public void hello(){
		System.out.println("B클래스 안녕");
	}
}

class C{
	int max = 100;		// 멤버변수 또는 필드 --> max변수는 gildong(), lime(), juwon()메소드 모두 사용 가능
	
	void gildong(){
		int min = 0;	// min변수는 gildong()메소드 안에서만 사용 가능

		System.out.println("=========gildong()메소드 시작");
		System.out.println("1. 문 앞으로 이동");
		System.out.println("2. 문 열기");
		System.out.println("3. 제자리로 되돌아오기");
		System.out.println("=========gildong()메소드 끝");
		return;		    // 생략가능
	}

	String lime(){
		System.out.println("=========lime()메소드 시작");
		System.out.println("1. 자판기 앞으로 이동");
		System.out.println("2. 동전 넣기");
		System.out.println("3. 커피 버튼 클릭");
		System.out.println("4. 커피를 들고 제자리로 되돌아오기");
		System.out.println("=========lime()메소드 끝");
		return "달콤한 커피";
	}

	String juwon(int coin){
		System.out.println("=========juwon()메소드 시작");
		System.out.println("1. 자판기 앞으로 이동");
		System.out.println("2. 동전 넣기");
		System.out.println("3. 콜라 버튼 클릭");
		System.out.println("4. 콜라를 들고 제자리로 되돌아오기");
		System.out.println("=========juwon()메소드 끝");
		return "톡쏘는 콜라";
	}
}

class MethodCallTest{
	public static void main(String[] args){
		//B b = new B();
		//b.hello();

		C c = new C();

		c.gildong();    //메소드 호출 c는 클래스C로 선언이 되어있음.
						//클래스C에 있는 gildong()메소드를 호출.

		String coffee = c.lime();
		System.out.println("라임에게 전달 받은 데이터 --> " + coffee);

		String cola = c.juwon(1000);
		System.out.println("주원에게 전달 받은 데이터 -->  " + cola);

		//메모리 할당 --> max변수, gildong(), lime(), juwon()
		System.out.println("MAX = " + c.max);
		//System.out.println("MIN = " + c.min);   에러 : 주소변수를 통해 지역변수를 사용하는 것은 불가. 호출 절대 불가!!!

	}
}