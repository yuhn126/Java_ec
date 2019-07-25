<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<%-- menu.jsp --%>
	<body>
		<ul>
			<li><a href="/struts/tiles/main.do">첫화면</a>
			<li><html:link action="/tiles/menu1">메뉴1</html:link>
			<li><html:link action="/tiles/menu2">메뉴2</html:link>
		</ul>
	</body>
</html>