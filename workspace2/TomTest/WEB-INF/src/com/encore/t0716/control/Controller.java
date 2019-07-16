package com.encore.t0716.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.t0716.dao.EmpDAO;
import com.encore.t0716.vo.Emp;

@WebServlet("/0716/empInfo")
public class Controller extends HttpServlet {
	EmpDAO dao;
	
	public Controller() {
		dao = new EmpDAO();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.요청분석  2.입력데이터얻기  3.모델객체생성,호출,[영역저장]  4.페이지이동  5.(옵션)유효성검사
		//샘플) 1. request.getParameter("action").equals("create")
		//		2. String username = request.egtParameter("username");
		//		3. DAO dao = new DAO();      List<String> list = dao.findAll();
		//		4. forward() 또는 redirect()
		//		5. if(username.length() < 1)
		
		List<Emp> emp = dao.findAll();
		req.setAttribute("emp", emp);
		//영역에 데이터저장을 왜 할까? ==> JSP(뷰)페이지공유
		//HttpSession session = req.getSession();
		//session.setAttribute("emp", emp);
		
		RequestDispatcher rd = req.getRequestDispatcher("/0716/emp_info.jsp");
		rd.forward(req, resp);
		//req.getRequestDispatcher("/0716/emp_info.jsp").forward(req, resp);
	}
}
