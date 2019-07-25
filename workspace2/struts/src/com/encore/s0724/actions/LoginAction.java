package com.encore.s0724.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.encore.s0723.dao.LoginProcess;
import com.encore.s0723.vo.UserInfo;
import com.encore.s0724.forms.LoginActionForm;

public class LoginAction extends Action{
	//Action == Controller
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, //ActionForm form = new LoginActionForm();
								 HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("execute()");
		
		//Action만 사용 ---> String id = request.getParameter("id");
		//ActionForm과 Action사용 시 ---> String id = form.getId();
		//							 ---> 유효성 검증된 데이터를 받겠음!
		
		//2. 
		LoginActionForm laf = (LoginActionForm)form;
		String id = laf.getId(); //절대 빈 값X, 아이디 내에 공백 문자x
		String pass = laf.getPass();
		
		//3.
		LoginProcess lp = new LoginProcess();
		UserInfo user = lp.login(id, pass);
		
		if(user == null) { //아이디X, 비번X
			ActionMessages msgs = new ActionMessages(); //메세지를 담는 바구니 객체
			
			//글로벌 메시지 추가
			msgs.add(ActionMessages.GLOBAL_MESSAGE, //PDF파일 p17
			//<html:messages id="msg" message="true"> 에 반응
					 new ActionMessage("invalidlogin"));
			//invalidlogin : 아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다.
			
			saveMessages(request, msgs); //뷰와 공유하기 위한 저장
			//execute()메소드의 리턴은 이동할 페이지 전용!
			
			return mapping.getInputForward();
			//<action>태그의 input속성에 정의된 페이지 리턴.
			
		} else { //로그인 성공
			//세션에 사용자 정보 저장
			//HttpSession session = request.getSession();
			request.getSession().setAttribute("user", user);
		}
		
		return mapping.findForward("loginForm");
		//<action>태그 내의 자식 태그<forward name="loginForm">에 정의된 페이지 리턴
		
	}//execute
}
