<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="com.encore.t0715.Person" id="p" scope="application"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>useBean액션 영역테스트</title>
	</head>
	<%-- useBean_action_scope.jsp --%>
	<body>
		<h3>useBean액션 영역테스트</h3>
		<%
			p.setName("나길동");
			
			//move.jsp이동
			request.getRequestDispatcher("move.jsp").forward(request, response);
		%>
		move.jsp이동
	</body>
</html>