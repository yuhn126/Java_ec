package com.encore.j0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	// [주된업무] 소켓 서비스
	// ---> 필요자원 : ServerSocket!
	// ---> 응답대기 : accept()
	// ---> 소켓채널에 대한 입출력
	// ---> 출력 write : 데이터 보내기, 입력 read : 데이터읽기
	public static void main(String[] args) throws IOException {
		// ServerSocket ss = new ServerSocket(int port);
		ServerSocket ss = new ServerSocket(5000);
		// 서버소켓을 실행하는 JVM이 갖는 ip주소와 명시된 port번호로 소켓서비스를 시작할 준비.

		System.out.println("서버시작(접속대기중).......");
		Socket s = ss.accept();// [2]클라이언트 접속 대기 메소드
		// s : 접속한 클라이언트의 소켓정보가 저장
		/// E:\hnyu\Java\Java_ec\workspace\JavaApp\bin>java com.encore.j0509.EchoServer

		String addr = s.getInetAddress().getHostAddress();
		System.out.println("클라이언트 접속 성공!");
		System.out.println(s);

		// [4] 소켓을 통한 입출력을 하기 위한 객체 생성
		InputStream is = s.getInputStream();// 읽기객체
		// 읽기 작업을 편하게 하기 위해
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		OutputStream out = s.getOutputStream();// 쓰기 객체
		//실제 통신(write전 -----> read후)
		//[5]write[6]read   [7]write[8]read
		
		// [5]메세지 보내기
		String msg = "점심 뭐 먹지?\n";	// \n : 구분자
		out.write(msg.getBytes());
		
		// [8]메세지 읽기
		String formMsg = in.readLine();
		System.out.println("From Client ==>" + formMsg);
		
	}// 서버 main
}




















