<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>사원정보출력</title>
	</head>
	<%-- emp_info.jsp --%>
	<body>
		<h3>사원정보</h3><hr>
		<table cellpadding="5">
			<tr bgcolor="moccasin">
				<th>empno</th><th>ename</th><th>dname</th><th>grade</th>
			</tr>
			<c:forEach items="${emp}" var="e">
				<tr>
					<td>${ e.empno }</td>
					<td>${ e.ename }</td>
					<td>${ e.dname }</td>
					<td>${ e.grade }</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>