<%@page import="com.encore.t0709.Calculator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>결과값</title>
	</head>
	<body>
		<%! String result; %>
		
		<%
			String su1 = request.getParameter("su1");
			String su2 = request.getParameter("su2");
			String oper = request.getParameter("oper");
			Calculator calc = new Calculator(Integer.parseInt(su1), Integer.parseInt(su2), oper);
			result = calc.getResultStr();
			
			out.print(calc.getResultStr());
		%>
		<hr>
		<%= result %>
		
	</body>
</html>