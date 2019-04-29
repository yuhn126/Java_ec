package com.encore.j0426;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ColorChangeTest extends Frame implements AdjustmentListener{
	Scrollbar sb_red, sb_blue, sb_green;	//이벤트 소스
	TextArea ta;
	Panel bigp, p1, p2, p3;
	
	public ColorChangeTest() {
		setTitle("색 바꾸기");
		
		//new Scrollbar(orientation, value, visible, minimum, maximum)
		sb_red = new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,265);
		sb_blue = new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,265);
		sb_green = new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,265);
		
		ta = new TextArea();
		ta.setBackground(Color.black);
		
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		
		p1.setLayout(new BorderLayout());
		p1.add("West",new Label("Red"));
		p1.add("Center",sb_red);
		
		p2.setLayout(new BorderLayout());
		p2.add("West",new Label("Blue"));
		p2.add("Center",sb_blue);
		
		p3.setLayout(new BorderLayout());
		p3.add("West",new Label("Green"));
		p3.add("Center",sb_green);
		  
		bigp = new Panel();
		bigp.setLayout(new GridLayout(5,1,0,10));
		bigp.setBackground(Color.orange);
		bigp.add(new Label());
		bigp.add(p1);
		bigp.add(p2);
		bigp.add(p3);
		 
		setLayout(new GridLayout());
		  add(bigp);
		  add(ta);
		 
		
		setSize(600,300);
		setVisible(true);
		
		eventUp();
	}
	
	
	
	private void eventUp() {
		sb_red.addAdjustmentListener(this);
		sb_blue.addAdjustmentListener(this);
		sb_green.addAdjustmentListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	//스크롤이 이동할 때 발생하는 이벤트
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
//		System.out.println("adjust");
		int r = sb_red.getValue();
		int b = sb_blue.getValue();
		int g = sb_green.getValue();
		
		System.out.println("red=" +r+" green=" + g + " blue=" + b);
		
		ta.append("red="+ r+", green="+g+", blue="+b+"\n");
		// 줄줄이~~
		
		/*
		<TextField tf에게 텍스트 주기>
			tf.setText("전달 문자열");
		<TextArea ta에게 텍스트 주기>
			ta.setText("전달 문자열");	- 이전 텍스트 clear, 새로운 텍스트 덮어쓰기
			ta.append("전달 문자열");  - 이전 텍스트에 이어쓰기
		 */                                                                      
		
		 ta.setBackground(new Color(r,g,b));
	}

	public static void main(String[] args) {
		new ColorChangeTest();
	}



}
