package com.encore.t0719.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		// req.getRequestDispatcher("/guest/inputForm.jsp").forward(req, res);//응답페이지
		String action = req.getParameter("action");
		String no = req.getParameter("no");

		if (action == null || action.equals("list")) {
			try {
				String pageNo = req.getParameter("page");
				
				int page;
				
				if(pageNo == null) {
					page = 1;
				} else {
					page = Integer.parseInt(pageNo);
				}
				
				//page를 기준한 start와 end값 구하기
				
				/*
					int end = page * 10; int start = end - 9;
				 
					Map<String, Integer> map = new HashMap<>(); map.put("start", start);
					map.put("end", end); list = dao.selectPage(map);
					
					List<Guest> list = dao.selectAll(page);
				*/
				
				List<Guest> list = dao.selectAll(page);
				int totalPage = dao.selectTotalPage();
				
				req.setAttribute("list", list);
				req.setAttribute("page", page);
				req.setAttribute("totalPage", totalPage);
				
				req.getRequestDispatcher("/0719/list.jsp").forward(req, res); // localhost:8282/TomTest/0719/list.jsp
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// response
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
//				try {
//					list = dao.selectAll();
//					req.setAttribute("list", list);
//					res.sendRedirect("/TomTest/guest/control");
//					// req.getRequestDispatcher("/0719/list.jsp").forward(req, res);
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
				
				res.sendRedirect("/TomTest/guest/control?action=list");
			} else {
				System.out.println("게시판 작성이 안되었어요.");
			}

		} else if (action.equals("edit")) {
			Guest vo = dao.selectById(Integer.parseInt(no));
			req.setAttribute("vo", vo);
			req.setAttribute("modPass", vo.getPass());
			req.getRequestDispatcher("/0719/editForm.jsp").forward(req, res);
		} else if (action.equals("update")) {
			Guest vo = new Guest();
			vo.setPass(req.getParameter("pass"));
			vo.setNo(Integer.parseInt(no));
			vo.setEmail(req.getParameter("email"));
			vo.setTel(req.getParameter("tel"));
			vo.setContents(req.getParameter("contents"));
			if (dao.update(vo)) {
//				try {
//					list = dao.selectAll();
//					req.setAttribute("list", list);
//					res.sendRedirect("/TomTest/guest/control");
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
				res.sendRedirect("/TomTest/guest/control?action=list");
			} else {
				System.out.println("ㄴㄴ");
			}
		} else if (action.equals("delete")) {
			if(dao.delete(Integer.parseInt(no))) {
				res.sendRedirect("/TomTest/guest/control?action=list");
			}
		}
	}// Service
}
