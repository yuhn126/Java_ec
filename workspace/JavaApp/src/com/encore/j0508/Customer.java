package com.encore.j0508;

public class Customer extends Thread{//경쟁적인 모금자(스레드)
	
	Account account;
	public Customer(Account account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 1; i <= 200; i++) {
				Thread.sleep(50);//0.05초 간격
				account.deposit(1000);
				System.out.println(getName() + " : " + i + "회");//자막효과
				if (account.getTotal() >= 500000) {//목표액(오십만원)달성
					break;
				}
			}//for
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}//run
}
