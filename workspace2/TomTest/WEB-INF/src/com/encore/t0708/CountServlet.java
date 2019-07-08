package com.encore.t0708;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class CountServlet extends HttpServlet {
	ArrayList<String> list;
	int cnt = 0;

	@Override
	public void init() throws ServletException {
		list = new ArrayList<>(); //1회 실행
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//한글을 한개라도 사용하면 글자 깨짐을 방지하기 위해 '문자셋'설정을 해야 함.
		
		//req : 요청객체(브라우저, 클라이언트), resp : 응답객체(서버, 출력)
		PrintWriter out = resp.getWriter(); //out : 브라우저 출력 객체
		//out.print("HTML텍스트");
		out.print("<html><head><title>ServletCount</title></head>");
		out.print("<body><h3>ServletCounter</h3><hr>");
		
		//동일 사용자(동일 브라우저 접속)의 경우 ==> 조회 수를 1 증가!
		//req == 브라우저

		//HttpSession session = req.getSession(); //세션은 접속이다!
		
		String addr = req.getRemoteAddr();//접속한 클라이언트
		
		if(!list.contains(addr)) {//이미 접속한 ip가 아니라면, ip주소가 list에 포함되어있지 않다면
			cnt++;
			list.add(req.getRemoteAddr());
		}
		
		out.print("조회수 : "+ cnt +"회 </body></html>");
		
	}// service
}
