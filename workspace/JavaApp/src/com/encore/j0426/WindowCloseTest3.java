package com.encore.j0426;

import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//프레임창 우측 상단의 x버튼 구현
public class WindowCloseTest3 extends Frame{
	
	public WindowCloseTest3() {
		setTitle("창닫기 테스트");
		
		setSize(300,300);
		setVisible(true);
		
		My m = new My();
		//addWindowListener(m); //프레임과 밑에 추가된 핸들러를 연결
		
		//addWindowListener(new My());
		
		/*
		//익명의 내부클래스(Anonymous InnerClass)
		addWindowListener(
				
				//extends WindowAdapter{	
				new WindowAdapter()
				{//클래스 시작
					
					@Override
					public void windowClosing(WindowEvent e) {
						System.out.println("x버튼 클릭~!");
						//프로그램 종료 == System.exit(정수);  정수 : 0, 양수[정상 종료] 또는 음수[비정상 종료]
						System.exit(0);
						//new ButtonMission();
					}
				}//클래스 끝
				
		);
		
		*/
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
//				System.exit(0);
				setTitle("허망...");
				//this ---> 현재 클래스(즉 내부클래스!!)
				//     ---> 내부클래스의 참조변수!!
			}
		});
		
		
	}//생성자
	
	public static void main(String[] args) {
		new WindowCloseTest3();
	}


}
