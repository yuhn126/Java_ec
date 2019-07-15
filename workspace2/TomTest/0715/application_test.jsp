<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>application객체 테스트</title>
	</head>
	<body>
		<h3>application(ServletContext)객체 테스트</h3><hr>
		1. 서블릿 컨테이너 이름 : <br>
		2. 서블릿 API버전 : <br>
		3. 현재 Context(=현재 웹 어플리케이션, 제품, TomTest)의 실제 경로(서버의 디스크 경로) : 
		<%= application.getRealPath("") %><br>
		<%
			//application.log("기록할 메시지"); ---> 필요한 정보 기록
			//문제) 어떤 사용자(ip)가 어떤 요청(get, post)을 했는지 파일로 기록하시오
			String addr = request.getRemoteAddr(); //접속 클라이언트의 up정보
			String method = request.getMethod(); //HTTP요청방식("GET", "POST")
			String protocol = request.getProtocol(); //HTTP요청 버전 : 1.0 1.1
			String path = request.getRequestURI();
			
			
			//서버에서 모니터링한 결과를 기록!
			String info = "접속한 클라이언트 정보 protocol : " + protocol + "<br> 요청방식 : " + method + "<br> 접속 IP : " + addr + "<br> 경로 : " + path 
							+ "<br> (" + new Date() + ")";
			System.out.println(info);
			out.print(info);
			application.log(info);
			
		%>
		<%-- <font color="blue"><%= su %></font> --%>
	</body>
</html>