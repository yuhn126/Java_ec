<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	</head>
	<%-- joinView.jsp --%>
	<body>
		<form action="control?action=loginConfirm" method="post">
		<h2>로그인</h2>
		<br>
		<table>
			<tr>
				<td>아이디 : </td>
				<td><input type="text" name="id" placeholder="ID"></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="password" name="password" placeholder="Password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="확인">
				<input type="button" value="취소" onclick="location.href='control'"></td>
			</tr>
		</table>
		</form>
	</body>
</html>