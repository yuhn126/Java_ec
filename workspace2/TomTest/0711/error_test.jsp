<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- errorPage="error.jsp" --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Error Test</title>
	</head>
	<body>
		<h3>에러 테스트</h3><hr>
		블루스크린 없는 하루~!
		<%
			out.print("<br>3*5=" + (3*5));
			out.print("<br>3/0=" + (3/0));
		%>
	</body>
</html>