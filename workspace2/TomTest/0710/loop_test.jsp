<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP반복문테스트</title>
	</head>
	<body>
		<h3>JSP반복문테스트</h3>
		<hr>
		<%
			for(int i = 0; i < 5; i++){
				out.print("<font color=blue>반복문안녕~!</font><br>");
			}
		
		%>
		<hr>
		<% for(int i=0; i<5; i++) { %>
			<font color=tomato>반복문 안녕!</font><br>
		<% } %>
	</body>
</html>