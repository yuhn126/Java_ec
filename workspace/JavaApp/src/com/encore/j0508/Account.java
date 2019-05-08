package com.encore.j0508;

public class Account {//모금함(저금통)
	private int total;
	
	public synchronized void deposit(int account) {
		total += account;
		//total = total + account;
//	실행순서  (3)     (1)      (2)
		/*
		 
			LOAD total
			
			ADD  account
			
			SAVE total
			
			
			동기화(synchronized)
			 - 메소드 동기화 : 메소드에 진입한 스레드가 있을 경우 다른 스레드들은 대기(LOCK)하게 하는 역할
			 			
			 			synchronized 리턴형 메소드명(){}
			 			
			 - 블럭 동기화 : 특정 영역 동기화
			 			
			 			synchronized(동기화객체){}
			 			
			 	예) synchronized(this){
			 			total += account;
			 		}
			
		 */
		
	}
	
	public int getTotal() {
		return total;
	}
}
