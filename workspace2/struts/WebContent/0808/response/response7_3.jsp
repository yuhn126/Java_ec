<%@page import="java.util.List"%>
<%@page import="com.encore.s0730.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- response7_3.jsp --%>
<%
     EmpDAO dao = new EmpDAO();
     List<String> list = dao.selectName();
     
     out.print("<font color=orange><ul>");
     for(int i=0; i<list.size(); i++){
    	 out.print("<li>"+list.get(i)+"</li>");
     }
     out.print("</ul></font>");
%>