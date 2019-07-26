<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<%-- a.jsp --%>
	<body>
		<h3>입력폼</h3><hr>
		<form action="b.jsp" method="post">
			이름 : <input type="text" name="username"><br>
			<input type="submit" value="전송"> 
		</form>
		<hr>
		안녕
	</body>
</html>