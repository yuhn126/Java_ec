package com.encore.j0426;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloseTest2 extends WindowAdapter{
	
	Frame f;
	
	public WindowCloseTest2() {
		f = new Frame("창 닫기 테스트");
		
		f.setSize(300,300);
		f.setVisible(true);
		
		f.addWindowListener(this); 	// f : 이벤트 소스,   windowClosing() : 이벤트 핸들러
		 
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("프레임 창 닫기");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new WindowCloseTest2();
	}
}
