package com.encore.t0708;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class CountServlet2 extends HttpServlet {
	// 접속한 클라이언트 ip주소와 조회수를 DB에 저장
	SqlMapClient smc; // 용도? XML문서내의 sql호출

	@Override
	public void init() throws ServletException {
		smc = MySqlMapClient.getSqlMapInstance();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		// 한글을 한개라도 사용하면 글자 깨짐을 방지하기 위해 '문자셋'설정을 해야 함.

		// req : 요청객체(브라우저, 클라이언트), resp : 응답객체(서버, 출력)
		PrintWriter out = resp.getWriter(); // out : 브라우저 출력 객체
		// out.print("HTML텍스트");
		out.print("<html><head><title>ServletCount</title></head>");
		out.print("<body><h3>ServletCounter</h3><hr>");

		String addr = req.getRemoteAddr();// 접속한 클라이언트

		System.out.println("접속한 클라이언트 >> [" + addr + "]");

		try {
			int count = (Integer) smc.queryForObject("count.select", addr);
			// count ==> 저장된 ip 존재 유무
			
			if (count == 0) { // 이미 저장 ip가 존재하지 않는다면
				smc.insert("count.insert", addr);
				smc.update("count.update");
			}
			
			out.print("조회수 : " + (Integer)smc.queryForObject("count.selectCnt") + "회 </body></html>");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// service
}
