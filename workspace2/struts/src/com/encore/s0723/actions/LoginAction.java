package com.encore.s0723.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.encore.s0723.dao.LoginProcess;
import com.encore.s0723.vo.UserInfo;

public class LoginAction extends Action{ //Action == Controller의미
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		/*
			ActionMapping : struts-config.xml에 매핑된 정보 얻어오기
			ActionForm    : 유효성 검사를 끝마친 <form>안의 데이터 저장된 정보 얻어오기
			ActionForward : execute()메소드 실행 후 이동할 페이지에 대한 정보를 담는 클래스
		*/
		
		//2. 데이터 얻기
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		//3.
		LoginProcess lp = new LoginProcess();
		UserInfo user = lp.login(id, pass);
		request.setAttribute("user", user); //뷰와 공유할 데이터 저장
		
		//4.
		ActionForward forward;
		if(user == null) //아이디 존재X 또는 비밀번호 일치X
			forward = mapping.findForward("fail");
		else { //아이디 존재 그리고 비번 일치(로그인 성공)
			forward = mapping.findForward("success");
			request.setAttribute("user", user);
		}
		
		return forward;
	}//execute

}
