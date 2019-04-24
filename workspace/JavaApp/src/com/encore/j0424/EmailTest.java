package com.encore.j0424;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Event;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class EmailTest extends Frame{
	TextArea ta;
	TextField tf1, tf2;
	Button b1;
	Label lb1, lb2;
	
	Panel NoP, SoP;
	
	public EmailTest() {
		setTitle("이메일 보내기");
		
		ta = new TextArea();
		tf1 = new TextField(20);
		tf2 = new TextField(20);
		b1 = new Button("전송");
		lb1 = new Label("보낸 사람 :");
		lb2 = new Label("받는 사람 :");
		
		NoP = new Panel();
		NoP.setLayout(new GridLayout(2,2,5,5));
		NoP.add(lb1);
		NoP.add(tf1);
		NoP.add(lb2);
		NoP.add(tf2);
		Event evt;
		Object what;
		NoP.action(evt, what)
		
		SoP = new Panel();
		SoP.add(b1);
		
		
		this.setLayout(new BorderLayout());
		add("North", NoP);
		add("Center", ta);
		add("South",SoP);
		
		setSize(300,300);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
		new EmailTest();
	}

}
