package com.encore.j0419;

public class StringTest {

	public static void main(String[] args) {
//		String str = "자바";		// 변수명과 구분하기위해 ""사용

//		String 문자열 : 문자들의 나열!
		String str = "JavaProgramming";
//		인덱스       	  012345678901234
		
//		str.~ String클래스에 있는~
		
//		문자열 길이(문자 갯수)
		System.out.println("str문자열 길이(문자갯수) : " + str.length());
		
//		부분 문자열 ---> "Pro"문자열 얻기
//		.substring(beginIndex, endIndex) beginIndex부터(포함) endIndex전 까지(비포함)
		System.out.println("str.substring(4, 7) : " + str.substring(4, 7));
//		str.substring(4, 7) --> 인덱스 4 부터 6 까지
		
//		부분 문자열 ---> "Programming" 문자열 얻기
		System.out.println("str.substring(4) : " + str.substring(4));
//		str.subSequence(4)  --> 인덱스 4 부터 끝까지
		
//		특정 인덱스의 문자 한1 자 얻어오기 : char str.charAt(int index)
		System.out.println("str.charAt(4) : " + str.charAt(4));
//		인덱스에 해당하는 한 문자 리턴!
		
//		특정 문자의 인덱스 얻어오기 : int str.indexOf(ch)
		int index1 = str.indexOf(97);		//아스키코드 97 = 'a'
		int index2 = str.indexOf('a');
//		 --> 'a'문자의 인덱스를 구할 수 있음.
		System.out.println("index : " + index1);
		System.out.println("index : " + index2);
		
		System.out.println( 97 == 'a' );
//		컴퓨터는 'a'문자를 내부에서 아스키숫자코드 97로 인식.
		
//		str에서 부분 문자열 "Programming"을 구하시오.
		System.out.println("str.substring(str.indexOf('P')) : " + str.indexOf('P'));
//		str.substring(4);
		
//		세번째'a'문자의 인덱스를 구하시오
		System.out.println("str.indexOf(\"am\") : " + str.indexOf("am"));
		
//		마지막'a'문자의 인덱스를 구하시오
		System.out.println("str.lastIndexOf('a') : " + str.lastIndexOf('a') );
		
//		문자열 치환(대체)
//		str.replace(char oldChar, char newChar) : 'a' ---> 'o'
		System.out.println("str.replace('a', 'o') : " + str.replace('a', 'o'));
//		"JovoProgromming"이 str에 저장되길 원한다면 
//		str = str.replace('a', 'o');
		System.out.println("STR : " + str);
		
//		"JavaProgramming" ---> "자바Programming"으로 변경하시오. (replace()메소드사용)
//		str.replace(Charsequence target, Charsequence replacement)
//		Charsequence 부모 - String 자식
		System.out.println("str.replace(\"Java\", \"자바\") : " + str.replace("Java", "자바") );
		
//		문자열에 공백 추가!
		str = "  " + str + "  ";	//str 앞에 공백 2개, 뒤에 공백 2개 추가
		System.out.println("공백 추가 후 STR : " + str);
		System.out.println("공백 추가 후 str문자열 길이 : " + str.length());
		
//		공백 제거!(문자열 앞뒤 연속된 공백 제거)
		str = str.trim();			//좌우 연속된 공백 제거!
		System.out.println("공백 제거 후 str문자열 길이 : " + str.length());
	}

}
