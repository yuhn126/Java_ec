<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품목록</title>
	</head>
	<%-- selProduct.jsp --%>
	<body>
		<h3>상품목록</h3><hr>
		<% 
			request.setCharacterEncoding("utf-8"); 
			String username = request.getParameter("username");
			if(username != null){ //로그인폼을 통해 username을 전달받았을때
				session.setAttribute("loginName", username);
			}
		%>
		<%-- [<%= request.getParameter("loginName") %>]님이 로그인한 상태입니다.<br><br> --%>
		[<%= session.getAttribute("loginName") %>]님이 로그인한 상태입니다.<br><br>
		<form action="add.jsp" method="post">
			<select name="product">
				<option>사과</option>
				<option>수박</option>
				<option>딸기</option>
				<option>바나나</option>
				<option>복숭아</option>
			</select>
			<button>추가</button>
		</form>
		<br><br>
		<a href="checkOut.jsp">장바구니 보기</a>
	</body>
</html>