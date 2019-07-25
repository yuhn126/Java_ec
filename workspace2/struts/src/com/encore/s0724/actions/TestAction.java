package com.encore.s0724.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.encore.s0724.forms.TestActionForm;

public class TestAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println("execute()");
		
		//한글 문자 집합 설정
		//request.setCharacterEncoding("utf-8"); //jsp 파일 기준!!
		TestActionForm taf = (TestActionForm) form;
		
		String name = request.getParameter("username");
		String age = request.getParameter("userage");
		
		System.out.println("이름 : " + name + ", 나이 : " + age);
		
		//return super.execute(mapping, form, request, response); 리턴을 통해 연결
		return mapping.findForward("gildong");
	}
}
