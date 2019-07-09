package com.encore.t0709;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/가상경로")
@WebServlet("/calc") //web.xml에 등록 대신 annotation을 사용하는 것이 가능
public class CalcServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.write("<html><head><title>Calculator</title></head>");
		out.write("<body><center><h3>서블릿 계산기</h3><hr>");
		out.write("<form method='post'><input type='text' size='5' name='su1'> ");
		out.write("<select name='oper'><option>+</option><option>-</option>");
		out.write("<option>*</option><option>/</option></select> ");
		out.write("<input type='text' size='5' name='su2'> ");
		out.write("<button type='submit'>계산</button>");
		
		String method = req.getMethod();
		System.out.println("HTTP요청방식(method) : " + method);
		if (method.equals("GET")) {
			doGet(req, resp);
		} else {
			doPost(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		if(req.getParameter("su1") == null || req.getParameter("su2") == null) {
			return;
		}
		int su1 = Integer.parseInt(req.getParameter("su1"));
		int su2 = Integer.parseInt(req.getParameter("su2"));
		System.out.println("doGet >> su1 : " + su1 + ", su2 : " + su2);
		
		String oper = req.getParameter("oper");
		
		
		out.print(" " + (su1+su2));
		out.write("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		int su1 = Integer.parseInt(req.getParameter("su1"));
		int su2 = Integer.parseInt(req.getParameter("su2"));
		System.out.println("doPost >> su1 : " + su1 + ", su2 : " + su2);
		
		out.print(" " + (su1+su2));
		out.write("</center></body></html>");
	}
}
