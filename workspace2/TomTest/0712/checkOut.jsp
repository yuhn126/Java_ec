<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>장바구니 결과 화면</title>
	</head>
	<body>
		<h3>선택된 상품 목록</h3><hr>
		<%! ArrayList<String> list; %>
		<%
			
			list = (ArrayList<String>)session.getAttribute("list");
			
			for(int i = 0; i <list.size(); i++){
				out.print(list.get(i)+"<br>");
			}
		%>
	</body>
</html>