package com.encore.j0425;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//프레임 위에 한개의 버튼의 배치(상단 가운데)하시오.
//버튼을 클릭(Action)했을 때 화면 콘솔에 '안녕'을 외치세요.
//조건) 이벤트 처리부(메소드)의 위치를 A클래스에 정의!

public class EventTest2 extends Frame{
	Button bt;
	
	public EventTest2() {
		setTitle("안녕");
		bt = new Button("너버튼");
		
		setLayout(new FlowLayout());
		add(bt);
		
		setSize(300,300);
		setVisible(true);
		
		A a = new A(this);//
		bt.addActionListener(a);
	}
	
	public static void main(String[] args) {
		new EventTest2();
	}

	
}
