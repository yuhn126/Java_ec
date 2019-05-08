package com.encore.j0507;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopySpeedTest {//★★★★★★★★★★★★★★
	//★파일 복사와 복사에 걸리는 시간을 체크!
	// a.txt파일을 읽어서 b.txt에 출력 : FileCopy!

	
	//1)바이트 단위 입출력
	FileInputStream fis;
	FileOutputStream fos;
	
	//2)문자 단위 입출력
	FileReader fr;
	FileWriter fw;
	
	//3)라인 단위 입출력 --> 문자들을 버퍼에 담았다가 한번에 읽고 쓰기.
	BufferedReader br;
	BufferedWriter bw;
	
	//4)바이트 단위 입출력(byte배열 사용)
	FileInputStream fis2;
	FileOutputStream fos2;
	
	public FileCopySpeedTest() throws Exception{
		fis = new FileInputStream("a.txt");		//FROM
		fos = new FileOutputStream("b.txt");	//TO
		int i;
		
		long start = System.currentTimeMillis();
		while((i = fis.read()) != -1) {//읽을 바이트가 있다면
			fos				.write   (i);
			// b.txt파일에 	    써라	  무엇을
		}
		long end = System.currentTimeMillis();
		
		System.out.println("[바이트단위]파일 복사 성공! : " + (end-start));
		
		fos.close();	//입출력객체 반환
		fis.close();	//입출력객체 반환
		
		//===========================================================
		
		fr = new FileReader("a.txt");
		fw = new FileWriter("b.txt");
		
		start = System.currentTimeMillis();
		while ((i = fr.read()) != -1) {
			fw				.write   (i);
			// b.txt파일에 	    써라	  무엇을
		}
		end = System.currentTimeMillis();
		
		System.out.println("[문자단위]파일 복사 성공! : " + (end-start));
		
		fw.close();
		fr.close();
		
		//===========================================================
		
		br = new BufferedReader(new FileReader("a.txt"));
		bw = new BufferedWriter(new FileWriter("b.txt"));
		
		String str;
		start = System.currentTimeMillis();
		while((str = br.readLine()) != null) {
			bw		.write  	(str);
		//				 	1.str을 읽어서
		//2. b.txt파일에 출력
		}
		end = System.currentTimeMillis();
		
		System.out.println("[버퍼사용]파일 복사 성공! : " + (end-start));
		
		bw.close();
		br.close();
		
		//===========================================================
		
		fis2 = new FileInputStream("a.txt");
		fos2 = new FileOutputStream("b.txt");
		
		start = System.currentTimeMillis();
		byte []b = new byte[1024]; 	//보통 512 또는 1024
		while((i = fis2.read(b)) != -1) {//i : 읽은 바이트 수 , b : 읽은 바이트 저장
			fos2.write(b,0,i);
			//b배열을 읽어서 fos2(b.txt)에 쓰기
		}
		end = System.currentTimeMillis();
		System.out.println("[바이트단위(배열)사용]파일 복사 성공! : " + (end-start));
		
		fos2.close();
		fis2.close();
		
		
	}//생성자

	public static void main(String[] args) throws Exception{
		new FileCopySpeedTest();
	}
}
