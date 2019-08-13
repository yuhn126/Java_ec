<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int i = 0;
	int j = 1;
%>
<html>
<head>
<meta charset="UTF-8">
<title>DVD Shop</title>
<script src="../../js/jquery-3.js"></script>
<script>
	
</script>
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
	padding: 30px;
	text-align: center;
	font-size: 35px;
	background-color: #f2f2f2;
}

/* Create two columns/boxes that floats next to each other */
nav {
	float: left;
	width: 20%;
	padding: 20px;
	background-color: e6e6e6;
}

article {
	float: left;
	padding: 20px;
	width: 80%;
	background-color: #d9d9d9;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: center;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<%-- mainView.jsp --%>
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
				<%@ include file="usersList.jsp"%>
			</div>
			<%
				} else {
			%>
			<div id="managersList">
				<%@ include file="managersList.jsp"%>
				<%
					}
				%>
			</div>
		</div>
	</nav>
	<article>
		<table>
			<tr>
				<th>포스터</th>
				<th>제목</th>
				<th>장르</th>
				<th>감독</th>
			</tr>
			<%
				
			%>
		</table>
	</article>
</body>
</html>