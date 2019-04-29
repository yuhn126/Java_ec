package com.encore.j0429;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseEventTest extends JFrame implements MouseListener {
	//mouse의 움직임 ---> 이벤트
	//            ---> 여러 컴포넌트에 공통적으로 적용할 수 있는 이벤트
	JButton bt;
	
	public MouseEventTest() {
		bt = new JButton("나버튼");
		
		setLayout(null);
		bt.setBounds(100,100,100,100);
		add(bt);
		
		setTitle("마우스 이벤트");
//		setSize(300,300);
		setBounds(600,200,300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt.addMouseListener(this);
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");	
	}
	
	
	public static void main(String[] args) {
		new MouseEventTest();
	}
}
