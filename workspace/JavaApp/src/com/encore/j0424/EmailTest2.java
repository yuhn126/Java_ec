package com.encore.j0424;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class EmailTest2 extends Frame{
	TextArea ta;
	TextField tf1, tf2;
	Button b1, b2;
	Label lb1, lb2;
	
	Panel NoP, SoP, NoUp, NoDw;
	
	public EmailTest2() {
		setTitle("이메일 보내기");
		
		ta = new TextArea();
		tf1 = new TextField(25);
		tf2 = new TextField(25);
		b1 = new Button("전송");
		b2 = new Button("취소");
		lb1 = new Label("보낸 사람 :");
		lb2 = new Label("받는 사람 :");
		
		NoUp = new Panel();
		NoUp.add(lb1);
		NoUp.add(tf1);
		
		NoDw = new Panel();
		NoDw.add(lb2);
		NoDw.add(tf2);
		
		NoP = new Panel();
		NoP.setLayout(new BorderLayout());
		NoP.add("North", NoUp);
		NoP.add("South", NoDw);
		
		
		SoP = new Panel();
		SoP.add(b1);
		SoP.add(b2);
		
		
		this.setLayout(new BorderLayout());
		add("North", NoP);
		add("Center", ta);
		add("South",SoP);
		
		setSize(300,400);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
		new EmailTest2();
	}

}
