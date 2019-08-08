<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--response8.jsp (Ajax요청에 대한 응답 페이지- 부분페이지!!) --%>
<h4>${deptno }번 부서정보</h4>
<table border="1" cellpadding=5>
  <tr bgcolor="skyblue">
     <th>사원번호</th>
     <th>사원명</th>
     <th>입사일</th>
  </tr>
 <c:forEach items="${list }" var="emp"> 
  <tr>
     <td>${emp.empno }</td>
     <td>${emp.ename }</td>
     <td><fmt:formatDate value="${emp.hiredate }" pattern="yyyy-MM-dd"/> </td>
  </tr>
 </c:forEach> 
</table>



