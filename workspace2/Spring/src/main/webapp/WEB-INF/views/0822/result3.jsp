<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과페이지2</title>
</head>
<%-- result3.jsp --%>
<body>
	<h3>결과페이지2</h3><hr>
	이름 : ${person.name }<br>
	나이 : ${person.age }<br>
	직업 : ${person.job }<br>
	<hr>
	전달받은 사람 정보 : ${person }
</body>
</html>