<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.encore.s0801.vo.EmpInfo"%>
<%@page import="java.util.List"%>
<%@page import="iba.MySqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<%--search_emp.jsp (HTML이 필요로 하는 table생성) --%>
<%
//search_emp.jsp?keyword=S&kindName=ename
		
    String keyword = request.getParameter("keyword");//"S"
    String kindName = request.getParameter("kindName");
    //"ename" "dname" "job"

    SqlMapClient smc = MySqlMapClient.getSqlMapInstance();
      Map<String,String> map = new HashMap<>();
          //map.put("keyword", keyword);
          //map.put(kindName,  kindName);
          map.put(kindName,"%"+keyword+"%");//map.put("ename","%S%");
    List<EmpInfo> list = smc.queryForList("emp.info", map);
%>
<table border="1" cellpadding="5">
  <tr bgcolor="#99ccff">
     <th>사원번호</th>
     <th>사원명</th>
     <th>입사일</th>
     <th>부서명</th>
     <th>직책</th>
  </tr>
 <%for(EmpInfo info:list){ %>
  <tr>
    <td><%= info.getEmpno()%></td>
    <td><%= info.getEname()%></td>
    <td><fmt:formatDate value="<%=info.getHiredate() %>" 
         pattern="yyyy/MM/dd"/> </td>
    <td><%= info.getDname()%></td>
    <td><%= info.getJob()%></td>
  </tr>
  <%} %>
</table>




