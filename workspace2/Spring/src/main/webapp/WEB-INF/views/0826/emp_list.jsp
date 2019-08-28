<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 리스트</title>
<script type="text/javascript">
	function search() {
		var search = document.frm.deptno.value;
		location.href="/Spring/emp/list?deptno=" + search; 
	}
</script>
</head>
<%-- emp_list.jsp --%>
<body>
	<form name="frm">
	<input name=deptno size=4> <button onclick="search()">조회</button>
	<table>
		<tr>
			<th>사원번호</th><th>사원이름</th><th>급여</th><th>부서번호</th>
		</tr>
		<c:forEach items="${list }" var="emp">
			<tr>
				<td>${emp.empno }</td>
				<td>${emp.ename }</td>
				<td>${emp.sal }</td>
				<td>${emp.deptno }</td>
			</tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>