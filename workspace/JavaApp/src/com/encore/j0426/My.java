package com.encore.j0426;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class My extends WindowAdapter{
	
	@Override
	public void windowClosing(WindowEvent e) {
//		System.out.println("x버튼 클릭~!");
		//프로그램 종료 == System.exit(정수);  정수 : 0, 양수[정상 종료] 또는 음수[비정상 종료]
		System.exit(0);
		//new ButtonMission();
	}
	
}
