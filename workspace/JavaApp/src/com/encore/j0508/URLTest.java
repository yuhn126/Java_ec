package com.encore.j0508;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.naver.com/index.html");
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트 : " + url.getHost());
			System.out.println("서비스파일명 : " + url.getFile());
			
			InputStream is = url.openStream();
			//웹소스 읽기 ---------> 화면 콘솔 출력
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
													  //ㄴ---> 바이트를 문자로 변환하는 클래스
			
			//BufferedWriter bw = new BufferedWriter(new FileWriter("test.html"));
//			
			String str;
//			while((str = br.readLine()) != null) {
//				System.out.println(str);
//				bw.write(str);
//			}
			//미션) 읽어들인 웹소스를 파일(test.html)로 저장하고
			//	      탐색기에서 'test.html'을 더블 클릭해서 해당 사이트를 접속하시오.
			//파일생성 		 ==> FileOutputStream, FileWriter
			//폴더(디렉토리)생성  ==> File
			
			//FileWriter fw = new FileWriter("test2.html");		--->	문자 집합 설정X
			
			//OutputStreamWriter osw = new OutputStreamWriter(OutputStream out, String charsetName);
			FileOutputStream fos = new FileOutputStream("test2.html");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
							
			while((str = br.readLine()) != null) {
				osw.write(str);
			}
			osw.close();
//			bw.close();
			br.close();
			
			System.out.println("파일 생성 성공!");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
