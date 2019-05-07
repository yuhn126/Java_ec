package com.encore.j0507;

import javax.swing.JFrame;

public class MyThread extends Thread{
	
	//스레드 특성을 갖는 메소드(동시실행)
	@Override
	public void run() {
		//동시 실행 할(기다리지 않는) 문장들
		try {
			for (int i = 1; i < 11; i++) {// 1~10
				//Thread.sleep(long millis);	millis : 밀리세컨드
				Thread.sleep(500);		//0.5초간 딜레이
				System.out.println("1번 스레드 : " + i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}//MyThread

class MyThread2 extends JFrame implements Runnable{
	@Override
	public void run() {
		try {
			for (int i = 1; i < 11; i++) {// 1~10
				//Thread.sleep(long millis);	millis : 밀리세컨드
				Thread.sleep(500);		//0.5초간 딜레이
				System.out.println("2번 스레드 : " + i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}