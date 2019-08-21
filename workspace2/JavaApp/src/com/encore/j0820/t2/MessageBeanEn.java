package com.encore.j0820.t2;

public class MessageBeanEn implements MessageBean{

	@Override
	public void sayHello(String name) {
		System.out.println("Hello, " + name + "!!");
	}
	
}
