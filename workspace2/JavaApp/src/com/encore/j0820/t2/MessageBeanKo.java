package com.encore.j0820.t2;

public class MessageBeanKo implements MessageBean{

	@Override
	public void sayHello(String name) {
		System.out.println("안녕, " + name + "!!");
	}
	
}
