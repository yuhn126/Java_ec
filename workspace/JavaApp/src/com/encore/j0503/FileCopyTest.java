package com.encore.j0503;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest {
	public static void main(String[] args) throws IOException {
		//문제1)a.txt파일을 읽어서 그 내용을 화면에 출력하시오.
		//    FROM					TO
		
		//읽기 객체 ---> InputStream, Reader
		// 대상      ---> File
		
		FileReader fr = new FileReader("a.txt");
		
		/*
		System.out.println(fr.read());
		System.out.println(fr.read());
		System.out.println(fr.read());
		System.out.println(fr.read());
		
		System.out.println(fr.read());
		System.out.println(fr.read());
		*/
		
		
		//문제2)a.txt파일을 읽어서 그 내용을 b.txt파일에 출력하시오. ---> 파일복사!
		//         FROM					TO
		FileWriter fw = new FileWriter("b.txt");
		
		int i;
		while((i=fr.read()) != -1) {
			System.out.print((char)i); //화면출력
			fw.write(i);//파일 복사
		}
		//자원반환!
		fw.close();
		fr.close();
	}
}
