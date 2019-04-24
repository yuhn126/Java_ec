package com.encore.j0424;

public class ExceptionTest2 {
	
	/*
		String[] args = { "10", "4" };
		String[] args = { "ab", "cd" };		NumberFormatException
		String[] args = { "10" };			ArrayIndexOutOfBoundsException
		String[] args = { "10", "0" };		ArithmeticException
		
		
		  su1   su2
		-------------
		  10     5
		  ab     cd
		  10     X 
		  10     0

		 run - run configuration!
	 */
	
	public static void main(String[] args) {
		try {
			System.out.println("매개변수로 받은 두개의 수");
			int su1 = Integer.parseInt(args[0]);	//new Number, Array
			int su2 = Integer.parseInt(args[1]);	//Number, new Array
			System.out.println("su1 = " + su1 + ", su2 = " + su2);
			System.out.println("su1을 su2로 나눈 몫 = " + (su1/su2));	//new Arithmetic
			System.out.println("나눗셈을 잘 실행하였습니다~!");
		}
		catch(NumberFormatException e){
			System.out.println("## 숫자만 입력하세요!");
		}
		// --> 부모Exception을 통해 통합처리 장점 : 코드가 간결하다
		catch(Exception e) {
			System.out.println("모든 예외처리 : " + e);
			return;
		}finally {
			System.out.println("finally : (try블럭내에서)예외발생과 상관 없이 반드시 실행!");
			//보통 FileSystem객체 또는 DataBase관련된 객체에 대한 반환
			//	         ㄴfr.close();     ㄴconn.close();
		}
		System.out.println("마지막 문장");		//catch내에 리턴이 있으면 실행xx
		
		
		//다중 catch장점 : 다양한 예외에 대해 각각 알맞은 처리를 할 수 있다.
//		catch(NumberFormatException e){
//			// e : 에러메세지 객체
////			e.printStackTrace();					//문제가 발생한 코드와 연관된 메소드들의 호출 관계를 표현
////			System.out.println("=======================================================================");
////			System.out.println(e.toString());		//예외 종류와 원인을 출력
////			System.out.println("=======================================================================");
////			System.out.println(e.getMessage());		//예외가 발생한 원인만 출력
//			System.out.println("## 숫자만 입력하세요!");
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("## 두개의 숫자를 반드시 입력하세요~!");
//		}catch(ArithmeticException e) {
//			System.out.println("## 0으로 나눌 수 없습니다");
//		}
		
	}
}
