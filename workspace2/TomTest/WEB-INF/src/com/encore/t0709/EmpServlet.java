package com.encore.t0709;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.t0709.dao.EmpDAO;
import com.encore.t0709.vo.Emp;

@WebServlet("/empInfo")
public class EmpServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>사원조회</title></head>");
		out.print("<body><center><h3>사원정보조회</h3><hr><table border='1'><tr><th>사원번호</th><th>사원명</th><th>입사일</th><th>급여</th><th>부서명</th></tr>");
		
		EmpDAO dao = new EmpDAO();
		List<Emp> list = dao.findAll();
		Emp emp = new Emp();
		for(int i = 0; i < list.size(); i++) {
			emp = list.get(i);
			out.print("<tr>");
			out.print("<td>" + emp.getEmpno() + "</td>");
			out.print("<td>" + emp.getEname() + "</td>");
			out.print("<td>" + emp.getHiredate() + "</td>");
			out.print("<td>" + emp.getSal() + "</td>");
			out.print("<td>" + emp.getDname() + "</td>");
			out.print("</tr>");
		}
		out.print("</table></center></body></html>");
		
	}
}
