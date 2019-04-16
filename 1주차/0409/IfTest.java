class D
{
	void hello(int su){
		if(su==1){
			System.out.println("안녕");
		}
		if(su==2){
			System.out.println("신짜오");
		}
		if(su==3)
			System.out.println("Hello");  //만약 if조건식의 결과에 따라 실행할 문장이 한개라면 {}영역 괄호 생략이 가능!
	}
}

class IfTest 
{
	public static void main(String[] args) 
	{
		D d = new D();
		d.hello(3);
	}
}
