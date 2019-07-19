package com.encore.t0719.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.t0719.dao.GuestDAO;
import com.encore.t0719.vo.Guest;

@WebServlet("/guest/control2") // 요청URL
public class GuestController2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1,2,3,4,5(옵션)
		String action = request.getParameter("action");
		if (action.equals("form")) {// 1.입력폼 보이기 요청
			request.getRequestDispatcher("/guest/inputForm.jsp")// 응답페이지
					.forward(request, response); // 4.
			
		} else if (action.equals("insert")) {// 1.

			// 2.데이터 얻기 ---> 얻은 데이터를 guest로 묶어주기
			Guest guest = new Guest(0, request.getParameter("writer"), request.getParameter("email"),
					request.getParameter("tel"), request.getParameter("pass"), request.getParameter("contents"), null);

			// 3.모델호출(영역저장), 페이지 이동
			GuestDAO dao = new GuestDAO();
			dao.insert(guest);
		}
	}
}
