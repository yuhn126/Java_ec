package com.encore.t0718;

public class Book {
	private String title;
	private String author;
	private int price;
	
	//Book 객체를 TomTest프로젝트(웹컨텍스트)의 모든 서블리솨 JSP가 공유하고 싶다!
	public Book() {
		title="스트럿츠MVC프레임워크";
		author="길라임";
		price=3500;
	}

	@Override
	public String toString() {
		return "Book [제목=" + title + ", 저자=" + author + ", 가격=" + price + "]";
	}
	
	
}
