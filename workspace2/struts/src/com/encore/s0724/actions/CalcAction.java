package com.encore.s0724.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.encore.s0724.forms.CalcActionForm;
import com.encore.s0724.model.Calculator;

public class CalcAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		CalcActionForm caf = (CalcActionForm)form;
		
		String su1 = caf.getSu1();
		String su2 = caf.getSu2();
		String oper = caf.getOper();
		
		Calculator calc = new Calculator(Integer.parseInt(su1), Integer.parseInt(su2), oper);
		request.getSession().setAttribute("result", calc.getResultStr());
		
		return mapping.findForward("calcForm");
	}
}
