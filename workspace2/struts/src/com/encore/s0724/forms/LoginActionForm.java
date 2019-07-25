package com.encore.s0724.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginActionForm extends ActionForm {
	// ActionForm : 사용자가 입력한 데이터를 검사(유효성 검사)
	// ---> 유효성 검사에 필요한 필드 정의
	// (HTML name과 일치하는 필드 정의, 필드에 대한 게터, 세터 메소드)
	// ---> 특성 메소드 validate()
	// ※ 주의사항) private int age; 보다
	// private String age;를 사용하는 것이 좋다!!!!!
	// setAge(Integer.parseInt(request.getParameter("age")));
	// ---> NumberFormatException발생 가능성!

	private String id;
	private String pass;

	public String getId() {
		System.out.println("getId()");
		return id;
	}

	public void setId(String id) {
		System.out.println("setId() : " + id);
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {

		this.pass = pass;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// 유효성 검사! (id --> 빈 값, 중간에 공백 문자 포함/ pass --> 빈 값)
		System.out.println("validate()");

		ActionErrors err = new ActionErrors(); // 에러(빈) 바구니 생성

		/*
		 * String str = "abcd"; str.indexOf("b") ---> 1 str.indexOf("a") ---> 0
		 * str.indexOf("f") ---> -1 str.indexOf("x") ---> -1
		 */

		// err.add("뷰와 공유할 새로운 키값", new ActionMessage("프로퍼티파일에 정의된 키 값"));
		if (id == null || id.length() == 0) { // 아이디 : 빈 값 체크
			// err.add("errid", "잘못된 아이디입니다.{0}");
			err.add("errid", new ActionMessage("invalidid", "아이디입력!"));
			// err.add("errid", "잘못된 아이디입니다.아이디입력!");

		} else if (id.indexOf(" ") > -1 || id.indexOf("\t") >= 0 || id.contains("\n")) { // 아이디 : 공백문자
			err.add("errid", new ActionMessage("invalidid", " 아이디에 공백을 제거!"));
			// err.add("errid", "잘못된 아이디입니다. 아이디에 공백을 제거!"));

		}
		// ---------------------------------------------------------------------------------------------------
		if (pass == null || pass.equals("")) { // 비밀번호 : 빈 값 체크
			// err.add("errpass", "비밀번호를 입력하지 않았습니다.");
			err.add("errpass", new ActionMessage("invalidpass"));
		}

		return err; // 빈 바구니, 에러메시지 담긴 바구니
	} // vaildate
}
