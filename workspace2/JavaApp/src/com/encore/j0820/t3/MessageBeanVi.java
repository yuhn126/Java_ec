package com.encore.j0820.t3;

public class MessageBeanVi implements MessageBean{

	@Override
	public void sayHello(String name) {
		System.out.println("신짜오, " + name + "!!");
	}
	
}
