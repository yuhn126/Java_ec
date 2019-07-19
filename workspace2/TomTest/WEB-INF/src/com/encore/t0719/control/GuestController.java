package com.encore.t0719.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.t0719.dao.GuestDAO;
import com.encore.t0719.vo.Guest;

@WebServlet("/guest/control")
public class GuestController extends HttpServlet {
	GuestDAO dao;
	List<Guest> list;

	public GuestController() {
		dao = new GuestDAO();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//req.getRequestDispatcher("/guest/inputForm.jsp").forward(req, res);//응답페이지
		String action = req.getParameter("action");
		String no = req.getParameter("no");

		if (action==null||action.equals("list")) {
			try {
				list = dao.selectAll();
				req.setAttribute("list", list);
				req.getRequestDispatcher("/0719/list.jsp").forward(req, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (action.equals("form")) {
			req.getRequestDispatcher("/0719/inputForm.jsp").forward(req, res);

		} else if (action.equals("insert")) {
			String username = req.getParameter("username");
			String email = req.getParameter("email");
			String tel = req.getParameter("tel");
			String pass = req.getParameter("pass");
			String contents = req.getParameter("contents");

			Guest vo = new Guest();
			vo.setWriter(username);
			vo.setEmail(email);
			vo.setTel(tel);
			vo.setPass(pass);
			vo.setContents(contents);

			if (dao.insert(vo)) {
				// insert가 되었다면
				System.out.println("게시판 작성완료");
				try {
					list = dao.selectAll();
					req.setAttribute("list", list);
					res.sendRedirect("/TomTest/guest/control");
					//req.getRequestDispatcher("/0719/list.jsp").forward(req, res);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("게시판 작성이 안되었어요.");
			}

		} else if (action.equals("edit")) {
			Guest vo = dao.selectById(Integer.parseInt(no));
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/0719/editForm.jsp").forward(req, res);
			
		} else if (action.equals("update")) {
			
		}
	}//Service

}