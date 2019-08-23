<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input</title>
</head>
<%-- input.jsp --%>
<body>
	<form action="result" method="post">
		이름 : <input type="text" name="name"><br>
		<input type="submit" value="등록">
	</form>
	<hr>
	<form action="good" method="post">
		<input type="submit" value="등록">
	</form>
</body>
</html>