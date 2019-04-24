package com.encore.j0424;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class TextFieldAreaTest extends Frame{
	TextField tf1, tf2;
	TextArea ta;
	Label la;
	Button b1;
	
	Panel pN,pS; //언제사용? 한 영역에 두 개 이상의 컴포넌트를 붙일 때
				 //컴포넌트 속성을 지정하기 위해 사용.
	
	public TextFieldAreaTest() {
		setTitle("TextFieldArea테스트");
//		new TextField(int columns); //columns : 글자 수가 들어가는 너비
		
		tf1 = new TextField("기본값",10);
		tf2 = new TextField(5);
		
		b1 = new Button("전송");
		
		ta = new TextArea();
		la = new Label("파일 이름 :");
		
		//pN.setBackground(Color c); //바탕색 설정
		pN = new Panel();
//		Color c = new Color(int red, int green, int blue);
		//매개변수의 각 정수는 0~255 사이의 값!
//		Color c = new Color(255,0,0);
		pN.add(tf1);
		pN.add(b1);
		pN.setBackground(new Color(0,255,0));
		
		pS = new Panel(); //컨테이너
		pS.setLayout(new FlowLayout()); //가운데 정렬, 기본 레이아웃은 flow임! 생략가능
		pS.setBackground(Color.pink); //바탕색 설정
		pS.setForeground(Color.red);
		pS.add(la);
		pS.add(tf2);
		
		this.setLayout(new BorderLayout());
		//BorderLayout의 경우 '위치설정'을 함께!!
		add("North", pN);
		add("Center", ta);
//		add("South", tf2);
//		add("South", la);
		add("South", pS);
		
		setSize(300,300);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new TextFieldAreaTest();
	}
}
