class InputTest
{
	public static void main(String[] args) throws Exception //예외 처리
	{
		System.out.println("프로그램 실행 도중 입력테스트");
		System.out.println("97출력 -> " + 97);
		System.out.println("(char)97출력 -> " + (char)97);

		System.out.println("================================");

		System.out.print("한자리 수를 입력 : ");
		int su = System.in.read() -48;		// 입력 받는 시점
		// 키보드 : 3          엔터
		//        51     13(CR) 10(LF)
		System.in.read();		// 13처리
		System.in.read();		// 10처리

		System.out.print("동일한 수를 다시 입력 : ");
		int su2 = System.in.read();		// 입력 받는 시점

		System.out.println("당신이 입력한 값은 " + su + "이고 그 수의 아스키 코드 값은 " + su2 + "입니다." );

		System.out.println("----END----");	
	}
}
