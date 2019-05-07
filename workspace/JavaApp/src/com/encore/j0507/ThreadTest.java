package com.encore.j0507;

public class ThreadTest {
	public static void main(String[] args) {
		MyThread t = new MyThread();		//t는 스레드 객체? --> (O)
		t.start();							//t.run();	   --> run()메소드를 직접 호출하면 일반메소드와 같은 실행(순차적인 실행)을 한다.
											//start()메소드는 '스레드 작업 스케줄러'!!
											//start()메소드에게 run()메소드를 위임하면 동시 실행 가능하게 함.
		
		
		MyThread2 r = new MyThread2();		//r은 스레드 객체? --> (X)		r.run();
		Thread t2 = new Thread(r);			//Runnable객체의 경우 Thread객체를 따로 생성하고, 매개변수를 사용해서 run()메소드의 위치를 표시.
		t2.start();
	}
}
