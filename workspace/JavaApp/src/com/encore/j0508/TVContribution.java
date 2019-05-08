package com.encore.j0508;

public class TVContribution {
	public static void main(String[] args) {
		//모금자(Thread) 5명 모집
		
		Account account = new Account();//한개의 모금함
		
//		Customer c1 = new Customer(account);
//		Customer c2 = new Customer(account);
//		Customer c3 = new Customer(account);
//		Customer c4 = new Customer(account);
//		Customer c5 = new Customer(account);
//		c1~c5 : Thread 객체
		
		//1차원 배열 객체 생성식 : 자료형[]배열명 = new 자료형[배열크기];
		Customer[] customers = new Customer[5];
		//		   customers = {null,null,null,null,null};

		for(int i = 0; i < customers.length; i++) {
			customers[i] = new Customer(account);
		}
		
		//모금시작
		for (int i = 0; i < customers.length; i++) {
			//c1.start(); == customers[0].start();
			customers[i].start();//스레드시작
		}
		
		try {
			for (int i = 0; i < customers.length; i++) {
				customers[i].join();//Waits for this thread to die
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("총 모금액 : " + account.getTotal() );
	}//main
}
