package com.encore.j0508;

class MyThread extends Thread {

	public MyThread(String name) {
		super(name);
	}

	public void run() {
		try {
			for (int i = 1; i < 11; i++) {
				Thread.sleep(500);
				System.out.println(getName() + " : " + i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

public class ThreadTest2 {
	public static void main(String[] args) {

		// 스레드의 기본 이름 : Thread-0 Thread-1 Thread-2
		// 스레드에 이름 부여하기!
		// new Thread(String name) name : 스레드 이름 설정
		MyThread t1 = new MyThread("길동스레드");
		MyThread t2 = new MyThread("라임스레드");
		MyThread t3 = new MyThread("주원스레드");
		
		//스레드 우선순위 (1~10) 10 : 우선순위 가장 높음, 기본값은 5
		t1.setPriority(Thread.MAX_PRIORITY);//10
		t2.setPriority(Thread.MIN_PRIORITY);//1
		t3.setPriority(Thread.NORM_PRIORITY);//5

		//스레드 실행
		t1.start();
		t2.start();
		t3.start();
	}
}
