package com.encore.s0725.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.encore.s0725.model.Guest;
import com.encore.s0725.model.GuestDAO;

public class GuestListAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GuestDAO dao = new GuestDAO();
		request.setAttribute("list", dao.selectAll());
		return mapping.findForward("list");
	}
}
