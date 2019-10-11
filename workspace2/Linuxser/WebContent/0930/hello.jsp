<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello</title>
</head>
<%-- hello.jsp --%>
<body>
	<h3>안녕</h3><hr>
	<%
		//드라이버 로딩(제품선택)
		Class.forName("org.mariadb.jdbc.Driver");
	
		//연결객체 생성 --> url, user, password
		Connection conn = DriverManager.getConnection("jdbc:mariadb://192.168.0.36:3306/mariaDB","scott","tiger");
		
		out.print("DB연결 성공");
		/*
			사용자 계정 생성
				CREATE USER '아이디'@'%' IDENTIFIED BY '비밀번호';
				CREATE USER 'scott'@'%' IDENTIFIED BY 'tiger';
			사용자 권한 주기
				GRANT ALL PRIVAILEGES ON 데이터베이스.* TO '아이디'@'%';
				GRANT ALL PRIVAILEGES ON mariadb.* TO 'scott'@'%';
			새로고침
				FLUSH PRIVILEGES;
		*/
		
			
		//
	%>
</body>
</html>