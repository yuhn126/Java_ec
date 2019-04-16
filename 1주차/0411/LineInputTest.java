import java.lang.*;	//기본패키지 --> 컴파일러가 자동으로 추가!

import java.io.BufferedReader;
import java.io.InputStreamReader;
	   //사용하겠음. 사용하고자 하는 클래스의 소속(폴더, 패키지)을 알려주는 역할
	   //형식) import 패키지명.클래스명;

class LineInputTest
{
	public static void main(String[] args)throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("숫자를 입력하세요 : ");
		String str = in.readLine();				// 입력시점!! 1 2 3 엔터
												// 처음 입력된 값부터 엔터 전까지를 문자열로 리턴
												
		System.out.println("STR = " + str);		//123출력
		System.out.println(str + 500);			//"123"+500 ---> "123500"

		// 숫자문자열 ---변환---> 숫자    "123" ---> 123 (큰따옴표 제거) : parseInt(숫자문자열)
		int su = Integer.parseInt(str);			//Integer.parseInt("123") ---> 123
		System.out.println(su + 500);			// 123 + 500 ---> 623
	}	
}

/*

	<자바 I/O의 4대 클래스>

					 읽기				쓰기
	==================================================
	byte단위		InputStream			OutputStream
	문자단위	  	   Reader			  Writer

*/