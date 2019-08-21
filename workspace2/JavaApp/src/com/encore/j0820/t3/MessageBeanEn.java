package com.encore.j0820.t3;

public class MessageBeanEn implements MessageBean{

	@Override
	public void sayHello(String name) {
		System.out.println("Hello, " + name + "!!");
	}
	
}
