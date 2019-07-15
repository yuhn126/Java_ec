<%@page import="com.encore.t0715.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<jsp:useBean class="com.encore.t0715.Person" id="vo"/>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:setProperty property="*" name="vo"/>
<!--  
	<jsp:setProperty property="age" name="vo"/>
	==> vo.setAge(Integer.parseInt(request.egtParameter("age"))); 
	
-->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>입력처리</title>
	</head>
	<%-- insertProcess.jsp --%>
	<body>
		<h3>DB입력처리</h3><br>
		<%
		
			/*
				String name = request.getParameter("name");
				String age = request.getParameter("age");
				String job = request.getParameter("job");
				Person vo = new Person();
				vo.setName(name);
				vo.setAge(Integer.parseInt(age));
				vo.setJob(job);
			*/
			
			out.print(vo);
			
			//PersonDAO dao = new Person();
			//dao.insert(vo);
			
		%>
	</body>
</html>