package com.encore.s0808.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.encore.s0808.model.EmpDAO;
import com.encore.s0808.model.EmpVO;

public class MissionAction3 extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String checked = request.getParameter("checked");
		String value = request.getParameter("value"); 
		List<EmpVO> list = null;
		
		EmpDAO dao = new EmpDAO();
		if(checked.equals("ename")) {
			list = dao.selectEnameInfo(value);
		} else if (checked.equals("deptno")) {
			list = dao.selectDeptInfo(Integer.parseInt(value));
		}
		request.setAttribute("list", list);
		
		return mapping.findForward("mission3");
	}
}
