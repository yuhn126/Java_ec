package com.encore.s0730;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EmpAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String deptno = request.getParameter("deptno");
		if(!deptno.matches("[\\d]+") && !deptno.equals("")) {
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print("<font color='tomato'><b>숫자만쓰삼</b></font>");
			return null;
		}
		EmpDAO dao = new EmpDAO();
		List<EmpInfo> list = null;
		if(deptno.equals("")) {
			int i = dao.selectMin();
			list = dao.selectDeptno(i);
			request.setAttribute("dept", i);
		} else {
			list = dao.selectDeptno(Integer.parseInt(deptno));
			request.setAttribute("dept", deptno);
		}
		request.setAttribute("list", list);
		return mapping.findForward("response8");
	}
}
