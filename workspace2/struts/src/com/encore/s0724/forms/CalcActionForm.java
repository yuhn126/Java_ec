package com.encore.s0724.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class CalcActionForm extends ActionForm {
	private String su1;
	private String su2;
	private String oper;

	public String getSu1() {
		return su1;
	}

	public void setSu1(String su1) {
		this.su1 = su1;
	}

	public String getSu2() {
		return su2;
	}

	public void setSu2(String su2) {
		this.su2 = su2;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors err = new ActionErrors(); // 빈 바구니
		if (su1 != null) {
			if (su1.length() == 0 || su2.equals("") || su1 == null || su2 == null) {
				err.add("errcalc", new ActionMessage("calc.input", "데이터를 입력하세요!"));
			} else if (!su1.matches("[\\d]+") || !su2.matches("[\\d]+")) {
				err.add("errcalc", new ActionMessage("calc.input", "숫자만 입력하세요!"));
			} else if (oper.equals("/") && su2.equals("0")) {
				err.add("errcalc", new ActionMessage("calc.divide", true));
			}
		} else {
			err.add("errcalc", new ActionMessage("calc.input", "잘못된 접근입니다."));
		}

		return err;
	}

}
