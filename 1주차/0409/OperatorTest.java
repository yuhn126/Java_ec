class OperatorTest{
	int test;			//멤버변수 위치에 변수 선언 가능!
	int trst2 = 300;	//멤버변수 위치에 선언과 초기화를 동시에 사용할 수 있음!

	public static void main(String[] arg){
	//main() 포함한 class : 자바 어플리케이션(Java application)
	//독립적으로 실행할 수 있는 자바 프로그램

		int su1;
		su1 = 40;
		int su2 = 30;
		
		System.out.println("<<su1과 su2의 사칙연산>>");
		// "문자열1"+"문자열2"		->		"문자열1문자열2"
		// "문자열1" + 33			->		"문자열33"
		// 55 + "문자열"			->		"55문자열"
		// 1+2+"안녕"			->		"3안녕"
		// "안녕"+1+2			->		"안녕12"
		
		System.out.println("su1 + su2 = " + (su1+su2));
		System.out.println("su1 - su2 = " + (su1-su2));
		System.out.println("su1 * su2 = " + (su1*su2));
		System.out.println("su1 / su2 = " + (su1/su2));
		System.out.println("su1 % su2 = " + (su1%su2));

		int su3 = 50;
		System.out.println("su3 = " + su3);
		su3++;
		System.out.println("후위연산후 su3 = " + su3);
		++su3;
		System.out.println("전위연산후 su3 = " + su3);

		System.out.println("후위연산 su3++ = " + su3++);
		System.out.println("다시 su3 출력 = " + su3);

		System.out.println("후위연산 ++su3 = " + ++su3);
		System.out.println("다시 su3 출력 = " + su3);

		System.out.println("==========비교연산자=========");

		int a=3, b=4;

		System.out.println(true);
		System.out.println(false);

		System.out.println("a<b : " + (a<b));
		System.out.println("a>b : " + (a>b));
		System.out.println("a==b : " + (a==b));
		System.out.println("a!=b : " + (a!=b));


	}
}