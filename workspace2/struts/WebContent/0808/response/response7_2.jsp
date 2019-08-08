<%@page import="java.util.List"%>
<%@page import="com.encore.s0730.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- response7_2.jsp --%>
<%
     EmpDAO dao = new EmpDAO();
     List<String> list = dao.selectName();
     out.print("[");
     for(int i=0; i<list.size(); i++){
    	 out.print('"'+list.get(i)+'"');
    	 if(i<list.size()-1)out.print(",");
     }
     out.print("]");
     
%>