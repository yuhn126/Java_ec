package com.encore.j0425;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonMission extends Frame implements ActionListener{
	Button bt1, bt2;
	
	public ButtonMission() {
		setTitle("미션");
		bt1 = new Button("안녕");
		bt2 = new Button("잘가");
		
		setLayout(new FlowLayout());
		add(bt1);
		add(bt2);
		
		setSize(300,300);
		setVisible(true);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("안녕")) {
			System.out.println("안녕~~!!");
		}else {
			System.out.println("잘가~~!!");
		}
		
	}

	public static void main(String[] args) {
		new ButtonMission();
	}
}
