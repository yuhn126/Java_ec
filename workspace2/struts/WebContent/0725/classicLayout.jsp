<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
		<head>
		<meta charset="UTF-8">
		<title>타일즈 레이아웃</title>
	</head>
	<%-- classicLayout.jsp --%>
	<body>
		<h3>TilesLayout테스트</h3>
		<table border="1" style="width: 100%;">
			<tr>
				<td colspan="2"><tiles:insert attribute="header"/></td>
			</tr>
			<tr>
				<td width="100"><tiles:insert attribute="menu"/></td>
				<td><tiles:insert attribute="body"/></td>
			</tr>
			<tr>
				<td colspan="2"><tiles:insert attribute="footer"/></td>
			</tr>
		</table>
	</body>
</html>