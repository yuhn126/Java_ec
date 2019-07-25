package com.encore.s0725.actions;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.encore.s0725.model.GuestDAO;

public class GuestPassCheckAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HashMap<String, Object> map = new HashMap<>();
		map.put("no", Integer.parseInt(request.getParameter("no")));
		map.put("pass", request.getParameter("pass"));

		GuestDAO dao = new GuestDAO();
		HttpSession session = request.getSession();
		String str;
		if (dao.selectPassCheck(map)) {
			str = "correct";
		} else {
			str = "incorrect";
		}
		session.setAttribute("result", str);

		return mapping.findForward("passForm");
	}
}
