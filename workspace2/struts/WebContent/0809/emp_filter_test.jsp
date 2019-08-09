<%@page import="java.io.PrintWriter"%>
<%@page import="com.encore.s0809.EmpVO"%>
<%@page import="java.util.List"%>
<%@page import="iba.MySqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	SqlMapClient smc = MySqlMapClient.getSqlMapInstance();
	List<EmpVO> list =  smc.queryForList("emp.selectAllInfo");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>emp_filter_test</title>
	<style>
	table {
		font-family: arial, sans-serif;
		border-collapse: collapse;
		width: 100%;
	}
	
	td, th {
		border: 1px solid #dddddd;
		text-align: left;
		padding: 8px;
	}
	
	tr:nth-child(even) {
		background-color: #dddddd;
	}
	</style>
	
	<script src="../js/jquery-3.js"></script>
	<script type="text/javascript">
		$(function() {
			$('button').click(function(){
				var ename = $('[name=ename]').val().toUpperCase();
				$('#myTable tr').filter(function() {
					var txt = $(this).text().toUpperCase();
					$(this).toggle(txt.indexOf(ename) > -1);
				})
			});
		});
	</script>
</head>
<%-- emp_filter_test --%>
<body>
	<input type="text" name="ename" placeholder="사원명" ]>
	<input type="text" name="sal" placeholder="급여" ]>
	<button>조회</button>
	<hr>
	<table>
		<!-- 그룹설정(thead, tbody(여러개 사용 가능), tfood(총합계 등의 결과 출력) -->
		<thead>
			<tr>
				<th>사원번호</th>
				<th>사원명</th>
				<th>입사일</th>
				<th>급여</th>
			</tr>
		</thead>
		<tbody id="myTable">
		<%
			for(int i = 0; i < list.size(); i++){
		%>
			<tr>
				<td><%= list.get(i).getEmpno() %></td>
				<td><%= list.get(i).getEname() %></td>
				<td><%= list.get(i).getHiredate() %></td>
				<td><%= list.get(i).getSal() %></td>
			</tr>
		<%  } %>
		</tbody>
	</table>
</body>
</html>