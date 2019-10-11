<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
</head>
<%-- list.jsp --%>
<body>
	<h3>목록보기</h3>
	<table border="1">
		<tr>  
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${list }" var="guest">
			<tr>
				<td>${guest.no }</td>
				<td>${guest.title }</td>
				<td>${guest.writer }</td>
				<td>${guest.date }</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>

