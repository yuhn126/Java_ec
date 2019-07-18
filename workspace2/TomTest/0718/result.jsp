<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 전송결과</title>
</head>
<%--result.jsp --%>
<body>
  <h3>파라미터 전송결과</h3>
  <hr>
    전달 이름: 
    <%= request.getParameter("username") %>
</body>
</html>