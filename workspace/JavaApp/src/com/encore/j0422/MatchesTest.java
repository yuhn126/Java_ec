package com.encore.j0422;

public class MatchesTest {
//	String클래스 --> boolean matches(String regex);
//	regex -------> regular expression (정규 표현식, 정규식)
//	regex를 통해 전달되는 패터네 str이 부합(match)된다면 true를 리던.
	
//	출현(발생)횟수에 관련된 부호 : ?(0,1), *(0~무한대), +(1~무한대)
//							부호없음 --> 1번 출현
	
	public static void main(String[] args) {
		String str = "";
		str = "abc";
							//matches(패턴문자열)
		System.out.println(str.matches("[a]"));		//a문자 : 한 번
		System.out.println(str.matches("[a]?"));	//a문자 : 0, 1
		System.out.println(str.matches("[a]*"));	//a문자 : 0 ~ 무한대
		System.out.println(str.matches("[a]+"));	//a문자 : 1 ~ 무한대
		System.out.println("=================================");
		System.out.println(str.matches("[abc]"));	//a 또는 b 또는 c 문자 중 한 번만 발생(출현)을 한다면 true리턴
		System.out.println(str.matches("[abc]+"));	//a 또는 b 또는 c 문자의 조합이 여러번 발생(출현)을 한다면 true리턴
		
		
		String name="gildong";
		//name변수에 대한 영문자 체크!
		System.out.println("name변수의 이름(영문자) 체크 : " + name.matches("[a-zA-Z]+"));
		//표현식 사용시 대괄호[]안의 '-'부호는 범위를 표현
		
		String su = "34567";
		//su변수에 대한 숫자 체크!
		
		System.out.println("숫자 체크 : " + su.matches("[0-9]+"));
		
		String hangul = "김길동";
		//hangul변수에 대한 한글 체크 !!
		System.out.println("한글 체크 : " + hangul.matches("[ㄱ-힣]+"));
	}
}
