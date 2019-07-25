package com.encore.s0724.forms;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class TestActionForm extends ActionForm{
	//유효성 검사하기 위한 속성정의(HTML name속성과 일치하는 필드 선언, 게터, 세터메소드 정의)
	private String username;
	private String userage;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserage() {
		return userage;
	}

	public void setUserage(String userage) {
		this.userage = userage;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	   //(set,validate전)선행작업
		/*
		 * try { request.setCharacterEncoding("UTF-8"); } catch
		 * (UnsupportedEncodingException e) { e.printStackTrace(); }
		 */
	}
	
	/*
		ActionForm의 메소드 실행 순서
		1. reset메소드		: 자동 호출
		1. set메소드		: 자동 호출
			setUsername(request.getParameter("username"));
		2. validate메소드	: 자동 호출
		-----------------------
		3. get메소드		: 자동 호출
		
	 */

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		System.out.println("validate()");
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		ActionErrors err = new ActionErrors(); //빈 바구니
		//ActionErrors : 에러메시지를 담는 바구니
		
		//err.add("뷰와 공유할 새로운 키 값", new ActionMessage("프로퍼티파일에 정의된 키 값"));
		//err.add("encore",new ActionMessage("mymsg")); //바구니에 에러메시지 담기
		
		//return null; //에러메시지 바구니 없음.
		return err; //ActionErrors : 에러메시지를 담는 바구니
	}
}
