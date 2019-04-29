package com.encore.j0426;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//프레임창 우측 상단의 x버튼 구현
public class WindowCloseTest extends Frame implements WindowListener{

	public WindowCloseTest() {
		setTitle("창닫기 테스트");
		
		setSize(300,300);
		setVisible(true);
		
		addWindowListener(this); //프레임과 밑에 추가된 핸들러를 연결
		
	}//생성자
	
	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("x버튼 클릭~!");
		//프로그램 종료 == System.exit(정수);  정수 : 0, 양수[정상 종료] 또는 음수[비정상 종료]
		System.exit(0);
//		new ButtonMission();
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
	
	public static void main(String[] args) {
		new WindowCloseTest();		
	}
}
