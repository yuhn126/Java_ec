<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<%-- print.jsp --%>
	<body>
		<h3>파라미터 데이터 출력</h3><br>
		<% request.setCharacterEncoding("utf-8"); %>
		이름 : <%= request.getParameter("username") %><br>
		나이 : <%= request.getParameter("userage") %><br>
		아무거나(존재하지 않는 파라미터) : <%= request.getParameter("any") %><br>
		<hr color="blue">
		이름 : ${param.username }<br>
		나이 : ${param.userage }<br>
		아무거나 [[${param.any }]]
		<%--
			${a}		---> 영역에서 a키를 찾아서 키에 저장된 데이터를 바로 출력ㄱ
			
			${a.b}		---> a키에 저장된 값은 반드시 클래스여야만 함!
							 만약 A클래스가 저장되어 있다면 A클래스 내의 getB()메소드의
							 리턴값을 얻어서 출력
			${param.a}	---> 폼 태그 내의 name속성에 저장된 값을 기준으로 데이터를 얻고 화면에 출력
		--%>
	</body>
</html>