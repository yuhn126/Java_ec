package com.encore.s0725.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.encore.s0725.model.Guest;
import com.encore.s0725.model.GuestDAO;

public class GuestAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = request.getParameter("action");
		
		
		ActionForward forward = null;
		if(action.equals("form")) { //입력폼 요청
			forward = mapping.findForward("form");
			
		} else if (action.equals("insert")) { //DB입력요청
			Guest guest = new Guest();
			guest.setWriter(request.getParameter("username"));
			guest.setEmail(request.getParameter("email"));
			guest.setTel(request.getParameter("tel"));
			guest.setPass(request.getParameter("pass"));
			guest.setContents(request.getParameter("contents"));
			
			GuestDAO dao = new GuestDAO();
			dao.insert(guest);
			forward = mapping.findForward("list");
		}
		
		return forward;
	}
}
