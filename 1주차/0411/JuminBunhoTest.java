import java.util.Calendar;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class JuminBunhoTest 
{
	public static void main(String[] args) throws Exception
	{
		// 주민번호를 입력받아 화면에 나이를 출력하기! (readLine() 메소드 사용)
		// "920306-1012345"
		// "080603-3012345"
		// ===> 전체 문자열에서 "92"만 추출하기 : String
		// 나이 계산하기?    2019 - (1990 + 92) + 1
		// 자바 날짜 관련된 클래스 : Date, Calendar ---> java.util 패키지

		Calendar cal = Calendar.getInstance();
		//cal변수 안에 현 시스템의 모든 날짜 관련 정보가 저장됨
		//cal.get(얻고자 하는 세부정보);

		int year = cal.get(Calendar.YEAR);
		//System.out.println("year : " + year);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("주민번호를 정확히 입력하세요('-'포함) : ");
		String id = in.readLine();		//"921126-1012345"   "080603-3012345"
					//인텍스                0123456789
		String birthYear = id.substring(0,2);

		char ch = id.charAt(7);		//ch ---> '1' '2' '3' '4' ...

		int age;
		if( ch < '3' ){
			age = year - (1900 + Integer.parseInt(birthYear)) + 1;
		}else{
			age = year - (2000 + Integer.parseInt(birthYear)) + 1;
		}

		System.out.println("당신의 나이는 : " + age);
	}
}
