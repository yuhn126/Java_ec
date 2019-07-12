<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<%-- start.jsp --%>
	<body>
		<h3>start.jsp(요청 페이지, 영역 객체, 영역 데이터 테스트)</h3>
		<%
			String name = "김길동";
			pageContext.setAttribute("name1", name);
			request.setAttribute("name2", name);
		%>
	</body>
</html>