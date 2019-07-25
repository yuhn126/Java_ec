package com.encore.s0724.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class TestActionForm extends ActionForm{
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		System.out.println("validate()");
		
		ActionErrors err = new ActionErrors(); //빈 바구니
		//ActionErrors : 에러메시지를 담는 바구니
		
		//err.add("뷰와 공유할 새로운 키 값", new ActionMessage("프로퍼티파일에 정의된 키 값"));
		err.add("encore",new ActionMessage("mymsg")); //바구니에 에러메시지 담기
		
		//return null; //에러메시지 바구니 없음.
		return err; //ActionErrors : 에러메시지를 담는 바구니
	}
}
