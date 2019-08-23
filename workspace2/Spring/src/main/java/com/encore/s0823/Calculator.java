package com.encore.s0823;

public class Calculator {//(사칙 연산 관련)기능정의
	//모델(데이터 관련된)클래스 : 보통 결과 데이터를 리턴!
	
	private int su1;
	private int su2;
	private String oper;
	
	private int result;		//사칙연산 결과를 담을 변수
	
	public Calculator(int su1, int su2, String oper) {
		this.su1 = su1;
		this.su2 = su2;
		this.oper = oper;
		choice();
	}
	
//	public int plus(int su1, int su2) {
//		return su1 + su2;
//	}
	
	private void choice() {
		if(oper.equals("+"))plus();
		else if(oper.equals("-"))minus();
		else if(oper.equals("*"))multi();
		else if(oper.equals("/"))div();
	}
	
	public void plus() {
		result = su1 + su2;
	}
	public void minus() {
		result = su1 - su2;
	}
	public void multi() {
		result = su1 * su2;
	}
	public void div() {
		result = su1 / su2;
	}
	
	
	//최종 결과값 리턴!
	public String getResultStr() {
		return "결과값 : " + su1 + oper + su2 + "=" + result;
	}
	
	
	
}
