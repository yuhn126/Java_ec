<%@page import="java.util.Map"%>
<%@page import="com.encore.s0729.EmpVO"%>
<%@page import="com.encore.s0729.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- empInfo.jsp --%>
<%
	EmpDAO dao = new EmpDAO();
	Map<String, Object> map = dao.selectEmpInfo(request.getParameter("ename"));
%>
<h3><%= map.get("ENAME") %>사원의 정보</h3><hr>
사원번호 : <%= map.get("EMPNO") %> <br>
사원명 : <%= map.get("ENAME") %> <br>
입사일 : <%= map.get("HIREDATE") %> <br>
부서명 : <%= map.get("DNAME") %> <br>
