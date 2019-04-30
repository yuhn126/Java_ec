package com.encore.j0430;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseMotionTest extends JFrame implements MouseMotionListener {
	//마우스모션(움직이기, 드래그하기) 이벤트 설정하기
	
	JLabel green, red;
	
	public MouseMotionTest() {
		setTitle("마우스 motion테스트");
		
		green = new JLabel("MOVE");
		  green.setBackground(Color.green);	//라벨은 바탕색 투명이 default
		  green.setOpaque(true);			//불투명 설정
		  
		red = new JLabel("DRAG");
		  red.setBackground(Color.red);
		  red.setOpaque(true);
		
		//green.setLo
		//green
		green.setBounds(30, 30, 80, 30);
		red.setBounds(30, 80, 80, 30);
		
		//x,y좌표  가로,세로길이
		setLayout(null);
		add(green);
		add(red);
		
		setBounds(300,200,500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addMouseMotionListener(this);	//프레임 위에서 마우스 움직임!
	}
	

	@Override
	public void mouseDragged(MouseEvent e) { //마우스 왼클릭상태로 이동
//		System.out.println("mouseDragged");
		red.setLocation(e.getX(),e.getY()-30);
	}

	@Override
	public void mouseMoved(MouseEvent e) {	//마우스 단순 이동
//		System.out.println("mouseMoved");
		int x = e.getX();
		int y = e.getY();
		green.setLocation(x,y-30);
		
	}
	
	public static void main(String[] args) {
		new MouseMotionTest();
	}
}
