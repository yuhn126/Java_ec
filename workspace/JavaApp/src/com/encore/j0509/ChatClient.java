package com.encore.j0509;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, Runnable {
	// 프레임 Center ---> JTextArea (서버가 보낸 메시지를 출력)
	// 프레임 South ---> JTextField (서버에게 보낼 메시지)

	// 채팅시 스크롤바
	// 닉네임 변경시 / 클라이언트 접속or종료 안내메시지

	JTextArea ta;
	JScrollPane scroll_ta;

	JTextField tf_send;

	OutputStream out;// 소켓쓰기
	BufferedReader in;// 소켓읽기

	JButton bt_change;

	JPanel southp;

	public ChatClient() {
		setTitle("대화방");
		ta = new JTextArea();
		ta.setFont(new Font("궁서체", Font.BOLD, 20));
		ta.setLineWrap(true); // 너비(가로)를 넘어가는 텍스트가 있다면 자동으로 줄바꿈
		scroll_ta = new JScrollPane(ta);
		tf_send = new JTextField(15);
		tf_send.setFont(new Font("궁서체", Font.BOLD, 20));

		bt_change = new JButton("대화명변경");
		/*
		 * - 최초 대화명 '길동이' - 대화 시도 : ta 출력 ==> [길동이] > 안녕하세요 <미션> - '대화명변경'버튼 클릭시 ---> 입력
		 * 대화상자 보이기 ---> '변경 대화명:' 입력 ==> 나길동 ---> 대화 시도 : ta 출력 ==> [나길동] > 안녕하세욧
		 */
		southp = new JPanel();
		southp.add(tf_send);
		southp.add(bt_change);

		add("Center", scroll_ta);
		add("South", southp);

		setBounds(300, 200, 600, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		connectProcess();// in,out객체 생성
		new Thread(this).start();// in객체 사용

		String nickName = JOptionPane.showInputDialog(this, "대화명 : ");
		toServer("100|" + nickName); // "100|홍길동" 닉네임 식별용

		tf_send.addActionListener(this);
		bt_change.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == tf_send) {
			String msg = tf_send.getText();
			if (msg.length() == 0) {// 빈값(문자열체크)
				return;
			}
			// 텍스트필드에 엔터가 입력되었을때
			toServer("200|" + msg); // "200|안녕하세요??"
			tf_send.setText("");
		} else if (ob == bt_change) {
			String cNickName = JOptionPane.showInputDialog(this, "변경 대화명 : ");
			if(cNickName == null) {
				return;
			}else {
				toServer("100|" + cNickName);
			}

			// ■미션 : 대화명 변경시 접속된 모든 클라이언트에게 [이름변경정보]를 ta에 출력!
			// 예) ****[길동이]님이 [나길동]님으로 이름 변경했습니다.****
		}
	}

	// 서버 소켓과 연결하는 작업
	public void connectProcess() {
		try {
			Socket s = new Socket("localhost", 3000);// 3.서버소켓연결

			// 4.소켓 입출력 객체 생성
			out = s.getOutputStream();
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 서버에게 메시지 보내기
	public void toServer(String msg) {
		try {
			out.write((msg + "\n").getBytes()); // ★5. 메시지 보내기 write
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {// 스레드 사용이유? GUI와 상관없이(동시에) 서버가 보내는 메시지를 대기해야 하기때문
		try {
			while (true) {
				String msg = in.readLine();// ★8. 서버가 보낸 (소켓을 통해 전달된)메시지 읽기
				ta.append(msg + "\n");
				ta.setCaretPosition(ta.getText().length());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// run

	public static void main(String[] args) {
		new ChatClient2();
	}

}
