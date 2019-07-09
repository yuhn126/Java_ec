package com.encore.t0709;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service()");
		//클라이언트의 요청 방식에 따라 doGet()또는 doPost()로 분기
		
		//HTTP요청방식(get,post)정보 얻어오기 --> HTTP요청은 클라이언트가 주체
		String method = req.getMethod();
		System.out.println("HTTP요청방식(method) : " + method);
		if (method.equals("GET")) {
			doGet(req, resp);
		} else {
			doPost(req, resp);
		}
		
		/*
		
		else if(method.equals("POST")) {
			doPost(req, resp);
		}
		
		*/
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()");
		//클라이언트가  HTTP요청 방식을 'get'으로 했을 때 호출되는 메소드
		/*
		<URL> /TomTest/0709/result?id=gildong&pwd=1234
								   -------------------
								                 파라미터
								                 
			String 속성값 = req.getParameter("name속성명"); 
		 */
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		System.out.println("doGet >> 전달받은 아이디 : " + id + ", 비번 : " + pwd);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost()");
		//클라이언트가  HTTP요청 방식을 'post'으로 했을 때 호출되는 메소드
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		System.out.println("doPost >> 전달받은 아이디 : " + id + ", 비번 : " + pwd);
	}
	
	/*
		 	<URL> http://192.168.0.96:8282/TomTest/0709/result?id=gildong&pwd=1234
	       ----   ------------ ---- ------- ----------- -------------------
	        통신프로토콜    	 호스트 PC	    포트넘버  웹컨텍스트  서비스페이지		 전달파라미터
	     					  ------
	     					  서비스채널(종류)
     					  
     					  
	 */
}
