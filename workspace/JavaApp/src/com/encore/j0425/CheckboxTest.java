package com.encore.j0425;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

public class CheckboxTest extends Frame{
	TextArea ta;
	Checkbox cb1, cb2, cb3, cb4;
	Panel northp, southp;
	Label la;
	
	public CheckboxTest() {
		setTitle("체크박스 테스트");
		
		ta = new TextArea();
		
		cb1 = new Checkbox("사과");
		cb2 = new Checkbox("딸기");
		
		// https://docs.oracle.com/javase/8/docs/api/
		CheckboxGroup asd = new CheckboxGroup();
		cb3 = new Checkbox("강아지", asd, true );
		cb4 = new Checkbox("고양이", asd, false);
		
		la = new Label("최애   :");
		
		northp = new Panel();
		northp.setLayout(new FlowLayout());
		northp.setBackground(Color.yellow);
		northp.add(cb1);
		northp.add(cb2);
		
		southp = new Panel();
		southp.setLayout(new FlowLayout());
		southp.setBackground(Color.orange);
		southp.add(la);
		southp.add(cb3);
		southp.add(cb4);
		
		
		this.setLayout(new BorderLayout());	//Frame 기본 레이아웃
		add("North", northp);
		//add("Center", ta);
		add(ta); //가능 ---> "Center"기본
		add("South",southp);
		
		setSize(300,300);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new CheckboxTest();
	}
}
