package com.encore.s0725.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.encore.s0725.model.Guest;
import com.encore.s0725.model.GuestDAO;

public class GuestUpdateAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
		Guest guest = new Guest();
		guest.setEmail(request.getParameter("email"));
		guest.setTel(request.getParameter("tel"));
		guest.setPass(request.getParameter("pass"));
		guest.setContents(request.getParameter("contents"));
		guest.setNo(Integer.parseInt(request.getParameter("no")));
		
		GuestDAO dao = new GuestDAO();
		dao.update(guest);
		
		return mapping.findForward("list");
	}
}
