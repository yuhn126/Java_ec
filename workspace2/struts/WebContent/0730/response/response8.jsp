<%@page import="com.encore.s0730.EmpInfo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- response8.jsp --%>
<%-- <%
	List<EmpInfo> list = (List)request.getAttribute("list");
%> --%>

<%
	List<EmpInfo> list = (List)request.getAttribute("list");
	if(list.size() > 0){
%>
<form>
	<h4>${dept }번 부서 정보</h4>
	<table cellpadding="4">
		<tr bgcolor="moccasin">
			<th>사원번호</th><th>사원명</th><th>입사일</th>
		</tr>
		<%-- <%
			for(int i = 0; i < list.size(); i++){
				out.print("<tr>");
				out.print("<td>" + list.get(i).getEmpno()+ "</td>");
				out.print("<td>" + list.get(i).getEname()+ "</td>");
				out.print("<td>" + list.get(i).getHiredate()+ "</td>");
				out.print("</tr>");
			}
		%> --%>
		<c:forEach items="${list}" var="c">
			<tr>
				<td>${c.empno }</td>
				<td>${c.ename }</td>
				<td>${c.hiredate }</td>
				<%-- ${c.hiredate }가 Date자료형일때!!
					<fmt:formatDate value="${c.hiredate }" pattern="yyyy-MM-dd"/> --%>
			</tr>
		</c:forEach>
	</table>
</form>
<%
	} else {
		out.print("<font color='tomato'>존재하지 않는 부서입니다.</font>");
	}
%>