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
	<title>회원가입</title>
	</head>
	<%-- joinView.jsp --%>
	<body>
		<form action="control?action=joinInsert" method="post">
		<h2>회원가입</h2>
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
				<td>이름 : </td>
				<td><input type="text" name="username" placeholder="Name"></td>
			</tr>
			<tr>
				<td>생년월일 :</td>
				<td>
					<select name="birthYear">
						<% for(int y = 1900; y <= year; y++){ %>
						<option><%= y %></option>
						<% } %>
					</select>
					<select name="birthMonth">
						<% for(int m = 1; m <= 12; m++){ %>
						<option><%= m %></option>
						<% } %>
					</select>
					<select name="birthDay">
						<% for(int d = 1; d <= 31; d++){ %>
						<option><%= d %></option>
						<% } %>
					</select>
				</td>
			</tr>
			<tr>
				<td>전화번호 : </td>
				<td><input type="text" name="tel" placeholder="Phone Number"></td>
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