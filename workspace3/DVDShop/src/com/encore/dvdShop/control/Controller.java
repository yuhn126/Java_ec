package com.encore.dvdShop.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.portable.RemarshalException;

import com.encore.dvdShop.model.dao.MovieDAO;
import com.encore.dvdShop.model.dao.RentalDAO;
import com.encore.dvdShop.model.dao.UserDAO;
import com.encore.dvdShop.model.vo.MovieVO;
import com.encore.dvdShop.model.vo.RentalVO;
import com.encore.dvdShop.model.vo.UserVO;

@WebServlet("/dvdshop/control")
public class Controller extends HttpServlet{
	MovieDAO md;
	UserDAO ud;
	RentalDAO rd;
	
	
	public Controller() {
		md = new MovieDAO();
		ud = new UserDAO();
		rd = new RentalDAO();
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		String action = req.getParameter("action");
		String loginNo = req.getParameter("loginNo");
		if (action == null || action.equals("list")) {
			try {
				List<MovieDAO> list = md.selectAll();
				req.setAttribute("movieList", list);
				req.getRequestDispatcher("/view/common/mainView.jsp").forward(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else if (action.equals("moviedetail")) {
			String movCode = req.getParameter("movCode");
			try {
				MovieVO mv = new MovieVO();
				mv = md.selectMovie(Integer.parseInt(movCode));
				req.setAttribute("selectMov", mv);
				req.getRequestDispatcher("/view/common/movDetail.jsp").forward(req, resp);
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
			
		} else if(action.equals("join")) {
			req.getRequestDispatcher("/view/user/joinView.jsp").forward(req, resp);
		
		} else if (action.equals("joinInsert")) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			String username = req.getParameter("username");
			String birth = req.getParameter("birthYear")+"-"+req.getParameter("birthMonth")+"-"+req.getParameter("birthDay");
			String tel = req.getParameter("tel");
			
			UserVO uv = new UserVO(0, id, password, username, birth, tel, 5);
			if(ud.insertUser(uv)) {
				resp.sendRedirect("/DVDShop/dvdshop/control");
			}
			
		} else if (action.equals("login")) {
			req.getRequestDispatcher("/view/common/loginView.jsp").forward(req, resp);
			
		} else if (action.equals("loginConfirm")) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			UserVO uv = new UserVO();
			uv.setUserId(id);
			uv.setPassword(password);
			int login = ud.loginConfirm(uv);
			if(login > 0) {
				session.setAttribute("loginCode", login);
				resp.sendRedirect("/DVDShop/dvdshop/control");
			} else {
				req.getRequestDispatcher("/view/common/loginView.jsp").forward(req, resp);
			}
			
		} else if (action.equals("logout")) {
			session.invalidate();
			resp.sendRedirect("/DVDShop/dvdshop/control");
			
		} else if (action.equals("movrental")) {
			RentalVO rv = new RentalVO();
			rv.setUserCode(Integer.parseInt(req.getSession().getAttribute("loginCode").toString()));
			rv.setMovieCode(Integer.parseInt(req.getParameter("movCode")));
			if(rd.insertRental(rv)) {
				resp.sendRedirect("/DVDShop/dvdshop/control");
			}
			
		} else if (action.equals("rentalList")) {
			if(req.getSession().getAttribute("loginCode") == null) {
				out.print("<script charset='euc-kr'>alert('Login Please!'); location.href='/DVDShop/dvdshop/control'</script>");
			} else {
				int userCode = Integer.parseInt(req.getSession().getAttribute("loginCode").toString());
				List<RentalVO> list = rd.selectUserList(userCode);
				req.setAttribute("selectUserList", list);
				req.getRequestDispatcher("/view/user/userRentalList.jsp").forward(req, resp);
			}
			
		}
		
		
//		else if (action.equals("rentalList")) {
//			req.setAttribute("login", );
//		}
	}
}
