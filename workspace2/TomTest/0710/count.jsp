<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>조회수</title>
	</head>
	<body>
		<%! int cnt; %>
		<%
			if(session.isNew())cnt++;
		%>
		<font color="tomato" size="12">조회수 : <%= cnt %>회</font>
		<br>세션아이디 : <%= session.getId() %>
	</body>
</html>