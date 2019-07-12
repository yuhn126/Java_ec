<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>전달데이터 출력</title>
	</head>
	<%-- print.jsp --%>
	<body>
		<h3>전달 파라미터 출력</h3><hr>
		<%--
			요청 페이지로부터 얻는 (한글)데이터에 대한 문자 집합 설정
			==> request.setCharacterEncoding("문자집합");
		 --%>
		 <% request.setCharacterEncoding("utf-8"); %>
		전달 나이 : <%= request.getParameter("age") %><br>
		전달 이름 : <%= request.getParameter("name") %><br>
	</body>
</html>