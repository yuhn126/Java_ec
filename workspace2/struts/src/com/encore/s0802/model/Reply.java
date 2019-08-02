package com.encore.s0802.model;

public class Reply {
	private int no;
	private String name;
	private String content;
	
	public Reply() {
		
	}
	
	public Reply(int no, String name, String content) {
		super();
		this.no = no;
		this.name = name;
		this.content = content;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
