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
		<h3>사원정보조회</h3><hr>
		<table border='1'>
			<tr>
				<th bgcolor="ffdddd">사원번호</th>
				<th bgcolor="ffeedd">사원명</th>
				<th bgcolor="ffffdd">입사일</th>
				<th bgcolor="eeffdd">급여</th>
				<th bgcolor="ddffee">부서명</th>
			</tr>
			<%
				EmpDAO dao = new EmpDAO();
				List<Emp> list = dao.findAll();
				Emp emp = new Emp();
				for(int i = 0; i < list.size(); i++) {
					emp = list.get(i);
					out.print("<tr>");
					out.print("<td>" + emp.getEmpno() + "</td>");
					out.print("<td>" + emp.getEname() + "</td>");
					out.print("<td>" + emp.getHiredate() + "</td>");
					out.print("<td>" + emp.getSal() + "</td>");
					out.print("<td>" + emp.getDname() + "</td>");
					out.print("</tr>");
				}
			%>
		</table>
	</body>
</html>