package com.encore.j0503;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException{
		/*
			<경로 표현 방법>
			- 전체경로(드라이브명과 중간 폴더 경로 전체, 절대 경로), 상대적인 경로, 생략된 경로
			- 자바의 경로는 '전체경로'가 기본!
				--> ImageIcon("경로");
				--> ImageIcon("Image/left.gif");	---> 이클립스의 프로젝트 중 JavaProject에서만 가능
			- 자바의 경로안의 문자는 대소문자를 구분하지 않음.
			
		*/
		//파일의 속성을 얻어오는 클래스
		//File f = new File(String path);
		//File f = new File("E:\\hnyu\\Java\\Java_ec\\workspace\\JavaApp\\a.txt"); // 기본
		// '\\' ---> '\'가 확장(기능)문자가 아니라 파일과 디렉토리를 구분하는 역할의 문자로 사용!
		File f = new File("a.txt");
		
		System.out.println("f파일(디렉토리)존재 유무 : " + f.exists());
		
		File f2 = new File("E:/hnyu/Java/Java_ec/workspace/JavaApp/a.txt");		//기본
			 f2 = new File("a.txt");	//생략된 경로(이클립스 내에서 가능)
			 f2 = new File(".");		// . 경로 : current directory(현재경로)
			 f2 = new File("..");		// .. 경로 : parent directory(부모경로)
			 f2 = new File("../..");
			 
		System.out.println("f2.getPath() : " + f2.getPath());
		System.out.println("f2.getAbsolutePath() : " + f2.getAbsolutePath());
		System.out.println("f2.getCanonicalPath() : " + f2.getCanonicalPath());		//실행 결과
		System.out.println("======================================================================");
		
		
		//File f3 = new File("src/com/encore/j0503/b.txt");//생략된 경로
		File f3 = new File("bin/com/encore/j0503/b.txt");//클래스 경로
		System.out.println("f3파일(디렉토리)존재 유무 : " + f3.exists());
		
		if (f3.isFile()) {//f3이 파일이면 true
			System.out.println("f3은 파일!");
		}
		if(f3.isDirectory()) {//f3이 폴더라면 true
			System.out.println("f3은 디렉토리!");
		}
		
		//문제) song폴더에 c.txt파일을 생성하시오.
		//참고 : FileWriter, FileOutputStream은 파일을 생성하는 기능을 갖는다!
		//new FileReader("c.txt"); ---> 없는 파일의 경우 에러 발생!
		//new FileWriter("c.txt");
		
		//new FileWriter("song/c.txt"); // --->존재하지 않는 폴더에 대해 에러발생\
		// ==> 해결방법) File클래스 사용 --> 폴더를 생성하는 기능 메소드 존재
		
		String path = "song/gildong/juwon";
		String fileName = "c.txt";
		
		File f4 = new File(path);
		
		
		if(f4.exists()) {
			System.out.println("#디렉토리가 이미 존재합니다.");
		}else {
			f4.mkdirs();
			System.out.println("#디렉토리를 새로 생성함!");
		}
		
		FileWriter fw = new FileWriter(path + "/" + fileName);
		//명시된 파일을 생성!
		fw.close();//자원반환
		
		/*
			File과 DataBase 사용이유? 데이터를 (프로그램 실행과 상관없이)지속적으로 저장, 관리하기 위해서.
			File과 DataBase 공통점? 데이터를 (서로 다른 프로그램, 개발자)공유!
		 */
		
		File f5 = new File("song/gildong/juwon/c.txt");
		System.out.println("c.txt파일 삭제 : " + f5.delete());
		
		
		File f6 = new File("song/gildong/juwon");
		System.out.println("f6 디렉토리 삭제 : " + f6.delete());// --> 빈 폴더 삭제 가능!
	}
	
	
	
}
