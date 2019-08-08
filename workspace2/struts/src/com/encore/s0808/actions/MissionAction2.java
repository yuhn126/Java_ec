package com.encore.s0808.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.encore.s0724.model.Calculator;

public class MissionAction2 extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		
		String su1 = request.getParameter("su1");
		String su2 = request.getParameter("su2");
		String oper = request.getParameter("oper");
		
		if (su1.length() == 0 || su2.equals("") || su1 == null || su2 == null) {
			request.setAttribute("result", "<font color=red>데이터를 입력하세요!</font>");
		} else if (!su1.matches("[\\d]+") || !su2.matches("[\\d]+")) {
			request.setAttribute("result", "<font color=red>숫자만 입력하세요!</font>");
		} else if (oper.equals("/") && su2.equals("0")) {
			request.setAttribute("result", "<font color=red>0으로 나눌 수 없습니다</font>");
		} else {
			Calculator calc = new Calculator(Integer.parseInt(su1), Integer.parseInt(su2), oper);
			request.setAttribute("result", "<font color=blue>"+calc.getResultStr()+"</font>");  
		}
		return mapping.findForward("mission2");
	}
}
