package com.encore.s0802.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.encore.s0802.model.Reply;
import com.encore.s0802.model.ReplyDAO;

public class ReplyAction extends Action{ //extends servlet해도됨
	//Action == 컨트롤러
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//1. (URL)요청 분석
		//컨트롤러.do?action=insert&name=나길동&content=나댓글
		//컨트롤러.do?action=delete
		//컨트롤러.do?action=update
		//컨트롤러.do?action=list
		String action = request.getParameter("action");
		String forwardName = null;
		ReplyDAO dao = new ReplyDAO();//3. 모델호출
		
		switch (action) {
			case "list":{
				request.setAttribute("list", dao.findAll());
				forwardName="list"; //reply_list.jsp로 이동!
			}break;
			
			case "insert":{//댓글 입력 요청
				//2.
				String name = request.getParameter("name");
				String content = request.getParameter("content");
				
				Reply vo = new Reply();
				vo.setName(name);
				vo.setContent(content);
				
				//포인트 : DB입력
				if(dao.create(vo)) {
					request.setAttribute("msg", "입력 성공");
				} else {
					request.setAttribute("msg", "입력 실패");
				}
				forwardName="result"; //메시지 출력할 jsp페이지
			}break;
			
			case "update":{//DB수정 요청
				String name = request.getParameter("name");
				String content = request.getParameter("content");
				int no = Integer.parseInt(request.getParameter("no"));
				
				Reply vo = new Reply(no, name, content);
				
				/*
				if(dao.modify(vo)) {//수정 성공하였다면
					request.setAttribute("msg", "수정 성공");
				} else {
					request.setAttribute("msg", "수정 실패");
				}
				forwardName="result"; //메시지 출력할 jsp페이지
				*/
				
				//간단 메시지의 경우 JSP페이지 없이 text만 전달하는 것이 가능!
				PrintWriter out = response.getWriter();//브라우저 출력 객체
				if(dao.modify(vo)) out.print("UpdateSuccess!!");
				else out.print("UpdateFail!!");
				return null;//특별히 이동할 JSP페이지 없음!
			}
			
			case "delete" : {
				int no = Integer.parseInt(request.getParameter("no"));
				PrintWriter out = response.getWriter();
				if(dao.remove(no)) out.print("DeleteSuccess!!");
				else out.print("DeleteFail!!");
				return null;
			}
		}//switch
		
		return mapping.findForward(forwardName); //4. 이동할 페이지 리턴(Action)
		/*
			return mapping.findForward("success");
			
			return mapping.findForward("fail");
			
		 	#struts-config.xml
		 	<action type="ReplyAction">
		 		<forward name="success" path="a.jsp">
		 		<forward name="fail" path="b.jsp">
		 	</action>
		*/
	}
}
