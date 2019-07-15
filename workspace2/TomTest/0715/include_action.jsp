<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>include_action</title>
	</head>
	<%-- include_action.jsp --%>
	<body>
		<h3>include_action.jsp</h3><hr color="tomato">
		<%
			int su = 300;
		%>
		<%-- <jsp:include page="application_test.jsp"/> --%>
		<%@ include file="application_test.jsp" %>
	</body>
</html>