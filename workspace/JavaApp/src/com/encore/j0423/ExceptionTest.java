package com.encore.j0423;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
   		<자바 I/O의 4대 클래스>	===> 추상클래스
   
   			  byte단위				        문자단위
        ----------------------------------------------
   	읽기      FileInputStream      	      FileReader		===> 대표메소드 : read()
   	쓰기	  FileOutputStream			  FileWriter		===> 대표메소드 : write()
   
 */

public class ExceptionTest {
	public static void main(String[] args) {
		
		//텍스트 파일(a.txt)을 읽어서 그 내용을 콘솔 (모니터)에 출력
//		try{
//			FileReader fr = new FileReader("a.txt");	//"읽고자하는 파일의 경로" FileNotFoundException(자식)
//			fr.read(); //IOException(부모)
//		}catch(FileNotFoundException fe) {
//			
//		}catch(IOException ie) {
//			
//		}
		
		
		//우클 - Surround With- try/catch block
		try {
			System.out.println("1번");
			FileReader fr = new FileReader("b.txt");	//"읽고자하는 파일의 경로" FileNotFoundException(자식)
			System.out.println("2번");
//			System.out.println(fr.read());	//IOException(부모)
//			System.out.println(fr.read());	//IOException(부모)
//			System.out.println(fr.read());	//IOException(부모)
//			System.out.println(fr.read());	//IOException(부모)
			
			int i;
			while((i = fr.read()) != -1) { //읽을 문자가 있다면
				System.out.print((char)i);
			}System.out.println();
			
//			System.out.println("#파일 읽기 성공");
		} catch (FileNotFoundException e) {
			System.out.println("#파일 경로를 확인하세요.");
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("#입출력 에러가 발생했습니다.");
//			e.printStackTrace();
		} finally {
			System.out.println("끝");
			//무조건 실행
		}
		
	}
}
