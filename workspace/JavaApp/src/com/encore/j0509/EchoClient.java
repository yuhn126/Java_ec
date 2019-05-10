package com.encore.j0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		// [3]서버접속 요청
		// Socket s = new Socket(접속할 서버의 정보);
		// Socket s = new Socket(String host, int port);
		Socket s = new Socket("localhost", 5000); // [3]
		// "localhost"는 자신의 PC를 의미 == "127.0.0.1"과 같다.
		// ==> 서버와 클라이언트의 위치가 같을 때 네트워크 트래픽없이 테스트용으로 사용.
		System.out.println("서버연결 성공~!^0^");

		// [4] 소켓을 통한 입출력을 하기 위한 객체 생성
		InputStream is = s.getInputStream();// 읽기객체
		// 읽기 작업을 편하게 하기 위해
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		OutputStream out = s.getOutputStream();// 쓰기 객체

		// [5]write[6]read [7]write[8]read

		// [6]메세지 읽기
		String msg = in.readLine();
		System.out.println("From Server ==>" + msg);
 
		String toMsg="연어회.......\n"; // \n : 구분자
		// [7]메시지 보내기
		out.write(toMsg.getBytes());

	}// 클라이언트 main
}
