<%@page import="com.encore.t0715.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
		<head>
		<meta charset="UTF-8">
		<title>useBean</title>
	</head>
	<%-- useBean_action.jsp
		 <useBean>태그는 특정 클래스의 객체를 생성하는 역할.
	 --%>
	<jsp:useBean class="com.encore.t0715.Person" id="p" scope="page"/>
	<%
		//Person p = new Person(); ==> 에러발생! 중복된 지역변수 p를 사용하였음!
		//즉, <jsp:useBean>의 id속성은 변수명으로 사용됨.
		Person p2 = new Person();
	%>
	<body>
		<h3>useBean_action.jsp</h3><hr>
		<%
			p.setName("홍길동");
		%>
		<jsp:setProperty property="age" name="p" value="13"/>
		<jsp:setProperty property="job" name="p" value="학생"/>
		<%= p %>
		<br>
		이름1 : <jsp:getProperty property="name" name="p"/><br>
		이름2 : <%= p.getName() %><br>
	</body>
</html>