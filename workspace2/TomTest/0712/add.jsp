<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품추가</title>
	</head>
	<%-- add.jsp --%>
	<body>
		<%! ArrayList<Object> list = new ArrayList<>(); %>
		<%
			request.setCharacterEncoding("utf-8"); 
			String selPro = request.getParameter("product");
			out.print("<script>alert('"+ selPro +"(이)가 추가되었습니다!!');history.back()</script>");
			
			if(selPro != null){
				list.add(selPro);
				session.setAttribute("list", list);
			}
		%>
	</body>
</html>