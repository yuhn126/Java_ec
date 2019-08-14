<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%
	int i = 1;
	int j = 0;
%>
<html>
<head>
<meta charset="UTF-8">
<title>대여 목록</title>
<link rel="stylesheet" href="../css/view.css" type="text/css">
</head>
<%-- userRentalList.jsp --%>
<body>
	<header>
		<h3>DVD Shop</h3>
	</header>
	<nav>
		<div id="nav">
			<%
				if (i > j) {
			%>
			<div id="userList">
				<%@ include file="../common/usersList.jsp"%>
			</div>
			<%
				} else {
			%>
			<div id="managersList">
				<%@ include file="../common/managersList.jsp"%>
				<%
					}
				%>
			</div>
		</div>
	</nav>
	<article>
		<table>
			<tr>
				<th></th>
				<th>제목</th>
				<th>장르</th>
				<th>감독</th>
				<th></th>
			</tr>
			<c:forEach items="${selectUserList}" var="movie" >
				<tr>
					<td><img width="130px" height="auto" src="${movie.image }" ></td>
					<td>${movie.movieTitle}</td>
					<td>${movie.ganre}</td>
					<td>${movie.director}</td>
					<td><input type="button" value="반납" ></td>
				</tr>
			</c:forEach>
		</table>
	</article>
</body>
</html>