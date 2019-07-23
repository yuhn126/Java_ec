<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 성공</title>
	</head>
	<%-- loginSuccess.jsp --%>
	<body>
		<h3>로그인 성공</h3><hr>
		<h4>사용자 정보</h4>
		<font color="tomato">
			이름 : ${user.username}<br>
			이메일 : ${user.email} <br>
			전화번호 : ${user.phone}<br>
		</font>
	</body>
</html>