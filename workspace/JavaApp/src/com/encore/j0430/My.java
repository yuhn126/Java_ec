package com.encore.j0430;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class You extends JButton{
	public You(String text) {
		super(text);
	}
}

class A{
	void hello(){
		System.out.println("안녕");
	}
	
}

public class My extends JFrame{
	JButton bt;
	You you;
	
	public My() {
		bt = new JButton("버튼1");
		
		setLayout(new FlowLayout());
		add(bt);
//		add(you);
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new My();
		
		A a  = new A() {
			
			@Override
			public void hello(){
				System.out.println("신짜오");
			}
		};
		
	}
}
