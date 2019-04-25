package com.encore.j0425;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A implements ActionListener{
	Frame f;	//Frame f = null;
	
	public A(Frame f) {//왼쪽클래스에 대한 정보를 받아올수있다.
		this.f = f;
//				203호
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//사건 발생 시 실행할 문장. (기능 정의)
		System.out.println("A클래스 안녕");
		
		f.setTitle("타이틀A");
	}
	
}
