<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>include test</title>
		
	</head>
	<%-- include_test.jsp(레이아웃 설정 페이지) --%>
	<body>
	<center>
		<h3>include directive(지시자) 테스트</h3>
		<hr>
		<%@ include file="menu.jsp" %>
		<table border="0" cellpadding="1">
			<tr>
				<td align="left">
					<font size="-1"><%@include file="shopping.jsp" %></font>
				</td>
				<td width="30">&nbsp;</td>
				<td align="left">
					<font size="-1"><%@include file="news.jsp" %></font>
				</td>
			</tr>
		</table>
	</center>
	</body>
</html>