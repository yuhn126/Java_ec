package com.encore.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.dao.GuestbookDAO;
import com.encore.vo.GuestbookVO;

@WebServlet("/guest") // guest?action=list guest?action=insert, update, delete
public class GuestController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		GuestbookDAO dao = new GuestbookDAO();

		String action = req.getParameter("action");

		if (action == null || action.equals("list")) {// 방명록 목록보기

			req.setAttribute("list", dao.selectAll());
			req.getRequestDispatcher("/guest/list.jsp").forward(req, resp);

		} else if (action.equals("form")) {// 방명록 입력폼

			req.getRequestDispatcher("/guest/inputForm.jsp").forward(req, resp);

		} else if (action.equals("insert")) {// 방명록 DB추가

			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");

			GuestbookVO vo = new GuestbookVO(0, title, content, writer, null);
			dao.insert(vo);

			resp.sendRedirect("/guest?action=list");

		} else if (action.equals("upform")) {// 방명록 수정폼
			int no = Integer.parseInt(req.getParameter("no"));
			// GuestVO guest =dao.select(no);
			req.setAttribute("guest", dao.select(no));
			req.getRequestDispatcher("/guest/upForm.jsp").forward(req, resp);

		} else if (action.equals("update")) {// 방명록 DB수정

			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String no = req.getParameter("no");

			GuestbookVO vo = new GuestbookVO(Integer.parseInt(no), title, content, null, null);
			dao.update(vo);

			resp.sendRedirect("/guest?action=list");

		} else if (action.equals("delete")) {// 방명록 DB삭제
			dao.delete(Integer.parseInt(req.getParameter("no")));
			resp.sendRedirect("/guest?action=list");

		}

	}
}
