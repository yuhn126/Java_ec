<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 이름</title>
</head>
<%-- emp.jsp --%>
<body>
	<h3>사원이름출력</h3>
	<hr>
	<ul>
		<c:forEach items="${list}" var="ename">
			<li>${ename }</li>
		</c:forEach>
	</ul>
</body>
</html>