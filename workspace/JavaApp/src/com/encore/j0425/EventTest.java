package com.encore.j0425;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//프레임에 버튼 한개를 (상단에)가운데 정렬해서 붙이자
//버튼을 눌렀을 때 콘솔화면에 '안녕'을 외치자!

/*
 <이벤트 처리> 기능 부여
 1. 컴포넌트에 적용할 이벤트 분석
 	---> 어떤 컴포넌트를 EventSource로 사용?
 	---> Button ---> ActionEvent
 	
 2. 인터페이스 만들기!
 	ActionEvent - Event : Action + Listener ==> ActionListener(인터페이스)
 */

public class EventTest extends Frame implements ActionListener {
	Button bt;
	int cnt = 0;
	Random r = new Random();

	public EventTest() {
		setTitle("이벤트 테스트");
		bt = new Button("나버튼");

		setLayout(new FlowLayout());
		add(bt);
		

		setSize(300, 300);
		setVisible(true);

		bt.addActionListener(this);

		// 4. 연결자(메소드) 등록 : 이벤트소스.add인터페이스명(이벤트처리부 위치);
		// --------
		// 사건을 발생시키는 컴포넌트
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cnt++;
		
		System.out.println("Hello");
		setTitle("이벤트테스트-" + cnt);
		Button newbutton = new Button("추가버튼[" + cnt + "]");
		
		newbutton.setBackground(new Color((r.nextInt(254)+1),(r.nextInt(254)+1),(r.nextInt(254)+1)));
		bt.setBackground(new Color((r.nextInt(254)+1),(r.nextInt(254)+1),(r.nextInt(254)+1)));
		
		add(newbutton);
		setVisible(true);
	} // 3. 이벤트 처리부(Event Handler) : 기능정의!

	public static void main(String[] args) {
		new EventTest();
	}
}
