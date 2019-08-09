<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table cellpadding="5">
	<thead>
		<tr bgcolor="tomato">
			<th>사원번호</th>
			<th>사원명</th>
			<th>급여</th>
			<th>부서번호</th>
			<th>입사일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="emp">
			<tr>
			    <td>${emp.empno }</td>
			    <td>${emp.ename }</td>
			    <td>${emp.sal }</td>
			    <td>${emp.deptno }</td>
			    <td>${emp.hiredate }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>