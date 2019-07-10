<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Param_Test</title>
	</head>
	<!-- HTML주석 -->
	<%-- JSP주석 --%>
	<%-- param_test.jsp --%>
	<body>
		<!-- 당신이 현재 페이지를 오픈한 시간 : <%= new Date() %> --><br>
		<%
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
		%>
		아이디    : <%=request.getParameter("id")%><br>
		비밀번호 : <%=pwd %>
	</body>
</html>