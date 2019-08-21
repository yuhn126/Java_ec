package com.encore.j0820.di;

public class MessageBeanImpl implements MessageBean{

	private String greeting;
	private String name;
	private FileOutput fo;

	@Override
	public void sayHello() {
		String str = greeting + ", " + name + "!!";
		System.out.println(str); //콘솔 출력
		fo.output(str);//파일출력
	}
	
	public MessageBeanImpl() {
		System.out.println("MessageBeanImpl기본생성자");
	}
	
	public MessageBeanImpl(String name) {
		System.out.println("MessageBeanImpl 오버로딩 생성자");
		this.name = name;
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void setFo(FileOutput fo) {
		this.fo = fo;
	}
	
}
