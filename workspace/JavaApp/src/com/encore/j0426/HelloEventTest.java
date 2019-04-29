package com.encore.j0426;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloEventTest extends Frame implements ActionListener{
	Checkbox cb1, cb2, cb3;
	TextField tf;
	Button bt_hello, bt_clear, bt_exit;
	Panel northp, centerp, southp;

	public HelloEventTest() {
		tf = new TextField(15);
		
		bt_hello = new Button("안녕");
		bt_clear = new Button("지우기");
		bt_exit = new Button("종료");
		
		CheckboxGroup cbg = new CheckboxGroup();
		cb1 = new Checkbox("자바 초급",cbg,true);
		cb2 = new Checkbox("자바 중급",cbg,false);
		cb3 = new Checkbox("자바 고급",cbg,false);
		
		setLayout(new BorderLayout());
		setTitle("안녕 이벤트");
		northp = new Panel();
		  northp.setLayout(new FlowLayout());
		  northp.setBackground(Color.orange);
		  northp.add(tf);
		centerp = new Panel();
		  centerp.setLayout(new GridLayout(3,1));
		  centerp.add(cb1);
		  centerp.add(cb2);
		  centerp.add(cb3);
		southp = new Panel();
		  southp.setLayout(new FlowLayout());
		  southp.setBackground(Color.pink);
		  southp.add(bt_hello);
		  southp.add(bt_clear);
		  southp.add(bt_exit);
		  
		add("North",northp);
		add("Center",centerp);
		add("South",southp);
		
		
		setSize(300,300);
		setVisible(true);
		
		bt_hello.addActionListener(this);
		bt_clear.addActionListener(this);
		bt_exit.addActionListener(this);
	}

	public static void main(String[] args) {
		new HelloEventTest();
	}

	@Override
	public void actionPerformed (ActionEvent e) {
		Object ob = e.getSource();
		if(ob == bt_hello) {
			if(cb1.getState()) {
				tf.setText("자바초급안녕~!");
			}else if(cb2.getState()) {
				tf.setText("자바중급안녕~!");
			}else if(cb3.getState()) {
				tf.setText("자바고급안녕~!");
			}
		}else if(ob == bt_clear) {
			tf.setText("");
		}else if(ob == bt_exit) {
			System.exit(0);
		}
		
	}
}
