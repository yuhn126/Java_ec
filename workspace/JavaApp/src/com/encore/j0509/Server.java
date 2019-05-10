package com.encore.j0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable {
	// 외부클래스 : 1. 소켓을 통한 접속서비스(접속대기)
	//			 2. 접속한 클라이언트를 관리(Vector통해)

	ServerSocket ss;
	Vector<Service> v; // 접속한 클라이언트 관리

	public Server() {
		System.out.println("Server Start...");
		v = new Vector<>();
		try {
			ss = new ServerSocket(3000); // ★1. 서버 소켓 객체 생성
			new Thread(this).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// 외부클래스 생성자

	public void run() {// 여러 클라이언트 접속에 대한 대기
		try {
			while (true) {
				Socket s = ss.accept(); // ★2. 클라이언트 접속 대기 (클라이언트 프로그램 : new Socket()과 매핑)
				// s : 소켓 정보를 가지고 있음! //service는 클라이언트 갯수와 같음
				
				//Service serv = new Service(s);
				//	+
				//v.add(serv); 
				v.add(new Service(s));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ----------------------------------------------------
		class Service extends Thread {// 내부클래스 : 소켓을 통한 입출력 서비스
			//※Service 객체 한 개 == 클라이언트 한 개!
			BufferedReader in; // 소켓을 통해 읽기
			OutputStream out; // 소켓에 쓰기
			
			String clientAddr;
			String nickName;
			String oldName;
			
			public Service(Socket s) {
	
				try {
					// ★4. 소켓 입출력 객체 생성
					in = new BufferedReader(new InputStreamReader(s.getInputStream()));
					out = s.getOutputStream();
					clientAddr = s.getInetAddress().getHostAddress();
					start();
				} catch (IOException e) {
					e.printStackTrace();
				}
	
			}// 내부클래스 생성자
			
			public void run() {//클라이언트가 보내는 여러 메시지를 읽어주는 기능
				while(true) {
					try {
						String msg = in.readLine();	// ★6. 클라이언트가 보낸 메시지 읽기
						//msg ----> "100|홍길동"	 "200|안녕하세요"
						//서버 모니터링
						System.out.println("[" + clientAddr + "] : "  + msg);
						
						String arr[] = msg.split("\\|");	// '|를 구분자로 쓰겠음'
						//arr = {"100","홍길동"}  arr = {"200","안녕하세요"}
						switch(arr[0]) {
							case "100":	//대화명 전달								
								nickName = arr[1];
								if(oldName == null) {
									messageAll("["+nickName+"]님이 입장하였습니다.");
									oldName = nickName;									
								}else{								
									messageAll("["+oldName+"]님이 [" + nickName +"]으로 이름을 변경하였습니다.");
									oldName = nickName;									
								}
								//nickName = arr[1];
								break;
							case "200": //메시지 전달
								messageAll("[" + nickName + "] : " + arr[1]);
						}
						
					} catch (IOException e) {
						System.out.println("#클라이언트가 접속을 끊었습니다.");
						messageAll("["+nickName+"]님이 퇴장하였습니다.");
						oldName = null;
						break;
					}
				}
			}//내부run
			
			public void messageTo(String msg) throws IOException {
			//특정 클라이언트에게 메시지 보내기
				out.write((msg + "\n").getBytes());	// ★7. 실제 클라이언트에게 메시지 보내기
			}
			
			public void messageAll(String msg) {
			//접속한 모든 클라이언트에게 메시지 보내기
				for (int i = 0; i < v.size(); i++) {//전체 클라이언트(Service벡터)
					Service serv = v.get(i);
					try {
						serv.messageTo(msg);
					} catch (IOException e) {
						//에러 발생 ===> 클라이언트 접속 끊음!(소켓은 사라졌지만 Service객페가 벡터에 존재
						v.remove(i--); //접속 끊긴 클라이언트를 벡터에서 삭제!
									   //i를 지우고 i -1;
						System.out.println("#클라이언트가 접속을 끊었습니다.");
						//messageAll("["+nickName+"]님이 퇴장하였습니다.");
						break;
					}
				} //for
			}//messageAll
			
		}//내부클래스
		

	// ----------------------------------------------------
	public static void main(String[] args) {
		new Server();
	}
}
