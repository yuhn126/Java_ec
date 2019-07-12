<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>세션테스트</title>
	</head>
	<%-- session_test.jsp --%>
	<body>
		<h3>세션테스트</h3><hr>
		<%
			//세션(연결)
			//session.setMaxInactiveInterval(1800*2);
			session.setMaxInactiveInterval(5);
			if(session.isNew()){ //브라우저를 통해 서버에 최초 URL요청을 했다면
				out.print("<script>alert('처음 접속하셨네요^0^')</script>");
			}
		%>
		
		1. 세션ID(서버가 브라우저에게 부여하는 식별 번호) : <%=session.getId() %><br>
		2. 세션 유지 시간 : <%= session.getMaxInactiveInterval() %>초 <br>
	
	</body>
</html>