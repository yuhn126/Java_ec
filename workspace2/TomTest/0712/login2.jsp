<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인폼</title>
	</head>
	<%-- login.jsp --%>
	<body>
		<h3>로그인 화면</h3><hr>
		<form action="selProduct2.jsp" method="post">
			이름 : <input type="text" name="username" size="10">
				  <input type="hidden" name="action" value="login">
			<%-- <% session.setAttribute("loginName", request.getParameter("username")); %> --%>
			<br><button>로그인</button>
		</form>
	</body>
</html>