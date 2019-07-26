<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- hello.jsp (응답페이지, HTML에 출력할 부분데이터 표현) --%>
<%
	System.out.println("hello.jsp페이지 요청!");
	System.out.println("전달이름 : " + request.getParameter("uname"));
%>

<font color="purple">안녕, ${param.uname}</font>
