<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean class="com.encore.t0715.Person" id="p" scope="application" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>move.jsp</title>
	</head>
	<%-- move.jsp --%>
	<body>
		<h3>move.jsp</h3><hr>
		사람정보 : <%= p %>
	</body>
</html>