<%@page import="java.sql.ResultSet"%>
<%@page import="com.sun.corba.se.spi.orbutil.fsm.Guard.Result"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.util.Properties"%>
<%@page import="com.encore.t0709.vo.Emp"%>
<%@page import="java.util.List"%>
<%@page import="com.encore.t0709.dao.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>사원정보조회</h3>
		<hr>
		<table border='1'>
			<tr bgcolor="tomato">
				<th>사원번호</th>
				<th>사원명</th>
				<th>입사일</th>
				<th>급여</th>
				<th>부서명</th>
			</tr>
			<%
				//conn.properties파일 안의 속성을 읽어서 아래의 적당한 위치한 데이터 설정
	
				String path = application.getRealPath("/");
				//현재프로젝트(WebContext)의 실제경로(하드디스크경로) 얻어오기
				System.out.println("현재 프로젝트의 경로>>>"+ path);
				//==> E:\jaelee\workspace2\TomTest\
				
				Properties pro = new Properties();
				pro.load(new FileReader("e:/hnyu/Java/Java_ec/workspace2/TomTest/conn/conn.properties"));
	
				//Class.forName("driver클래스명");
				//Connection conn = DriverManager.getConnection("DB접속url", "user","password");
				Class.forName(pro.getProperty("driver"));
				Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro);
				System.out.println("DB연결성공!!");
				
				String sql = "select empno, ename, hiredate, sal, dname from emp e join dept d on e.deptno=d.deptno";
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				
				
				while(rs.next()){
			%>
			<tr>
				<td><%= rs.getInt("empno") %></td>
				<td><%= rs.getString("ename") %></td>
				<td><%= rs.getDate("hiredate") %></td>
				<td><%= rs.getInt("sal") %></td>
				<td><%= rs.getString("dname") %></td>
			</tr>
			<%
				 }
			%>
		</table>
	</body>
</html>



