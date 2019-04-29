package com.encore.j0429;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest extends JFrame{
	
	JButton bt;
	
	public SwingTest() {
		setTitle("Swing테스트");
		
		bt = new JButton("<html><font size=20 color=blue face=궁서체>나버튼</font></html>");
		
		setLayout(new FlowLayout());
		add(bt);
		
		setSize(300,300);
		setVisible(true);
		
		//만약 프레임 우측 상단의 x버튼 클릭시 프로그햄 종료만 할 것이라면 아래의 코드 사용!
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//x버튼에 기능 부여할 것 이면  addWindowListener()사용!
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
	}
	public static void main(String[] args) {
		new SwingTest();
	}
	
	
}
