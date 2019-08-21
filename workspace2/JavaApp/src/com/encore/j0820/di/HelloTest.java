package com.encore.j0820.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("com/encore/j0820/di/applicationContext.xml");
		// ---> applicationContext.xml에 등록된 클래스를 사용 할 준비작업이 끝났음!
		
		MessageBean msg = (MessageBean) ctx.getBean("msgBean");
		
		msg.sayHello();
	}
	
}
