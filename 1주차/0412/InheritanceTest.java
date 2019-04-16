//컴파일러가 import java.lang.*; 추가

class Parent{
	int i = 11;

	void hello(){
		System.out.println("안녕~!!");
	}

	void hello(String name){//-----> 오버로딩메소드(메소드명 같고 인자의 갯수 또는 자료형이 다른것)
		System.out.println("안녕," + name);
	}

	void hello(int age){ // 오버로딩 메소드
		System.out.println("안녕," + age);
	}

	void print(){
		System.out.println("부모프린트!");
	}

}

class Child extends Parent{
			//is a      => 자식은 부모다!!
			//          => 자식클래스는 부모클래스로 형변환이 가능하다!
	int j=22;

	void goodBye(){
		System.out.println("안녕히가세요~!");
	}
	void print(){//------> 오버라이딩메소드(재정의 메소드)
		System.out.println("자식프린트");
	}
}

class InheritanceTest{
	public static void main(String[] args) {
		Child c = new Child();		//메모리: O P C
			//자신의 자원
		System.out.println("J = " + c.j);
		c. goodBye();
		c. print();
		
		//부모의 자원
		c.hello();
		//c.abc();		//에러 : Child, Parent, Object클래스에 존재하지 않기 때문에 에러!
		c.toString();   //컴파일 잘 되는 이유? Object 클래스에 toString()메소드가 정의되었기 때문


		System.out.println("==========================");
		Parent p = new Parent();
		//자신의 자원
		p.hello();
		p.print();

		//자식의 자원
		//p.goodBye(); //에러발생
		//기본 : 부모참조변수(p)를 통해 자식 접근 불가능!

		//부모			 자식
		Parent p2 = new Child();	// 메모리할당 : O  P  C
		//----     -------------
		//기준      변환가능한지 여부?

		p2.hello();
		p2.print();		//기본원칙 : 부모참조 통해 자식 호출 불가!!
						//예외   : 오버라이딩 메소드는 호출 가능!!
						//		==> 정확히
						//		==> 오버라이딩 메소드가 존재한다면 부모의 메소드는 은폐되고
						//          자식의 메소드로 대체가 된다.
	}
}
