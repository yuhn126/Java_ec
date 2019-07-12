<%@page import="java.util.ArrayList"%>
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
		<h3>상품목록</h3>
		<hr>
		<%
			request.setCharacterEncoding("UTF-8");
			String userName = request.getParameter("username");
	
			//userName을 세션에 저장하자!!
			//왜? 로그인폼에서 (입력)전달된 값을 같은 브라우저에서 유지하기 위해!!
			if (userName != null)//로그인폼을 통해 username을 전달 받았을때
				session.setAttribute("loginName", userName);
			
			//checkOut.jsp ==> location.href='selProduct.jsp?action=remove'
			String action = request.getParameter("action"); //remove
			ArrayList<String> cartList = (ArrayList<String>)session.getAttribute("fruitsName");
			
			if(action != null && action.equals("remove")){
				//장바구니 비우기
				cartList.clear();
			}
		%>
		<%-- [<%= request.getParameter("loginName") %>]님이 로그인한 상태입니다.<br><br> --%>
		[<%=session.getAttribute("loginName")%>]님이 로그인한 상태입니다.
		<br>
		<br>
		<form action="add2.jsp" method="post">
			<select name="product">
				<option>사과</option>
				<option>수박</option>
				<option>딸기</option>
				<option>바나나</option>
				<option>복숭아</option>
			</select>
			<button>추가</button>
		</form>
		<br>
		<br>
		<a href="checkOut2.jsp">장바구니 보기</a>
	</body>
</html>