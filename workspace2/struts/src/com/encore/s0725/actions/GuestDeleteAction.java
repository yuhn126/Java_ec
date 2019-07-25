package com.encore.s0725.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.encore.s0725.model.GuestDAO;

public class GuestDeleteAction extends Action {
	// 삭제처리

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GuestDAO dao = new GuestDAO();
		dao.delete(Integer.parseInt(request.getParameter("no")));

		return mapping.findForward("list");
	}
}
