<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.encore.s0731.AddrDAO"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<String> list=null;
	
	if (request.getParameter("load").equals("sido")) {
		AddrDAO dao = new AddrDAO();
		list = dao.selectSido();
		/* for (int i = 0; i < list.size(); i++) {
			out.print("<option>" + list.get(i) + "</option>");
		} */
	} else if (request.getParameter("load").equals("gugun")) {
		AddrDAO dao = new AddrDAO();
		list = dao.selectGugun(request.getParameter("sido"));
		/* for (int i = 0; i < list.size(); i++) {
			out.print("<option>" + list.get(i) + "</option>");
		} */
	} else if (request.getParameter("load").equals("dong")) {
		Map<String, String> map = new HashMap<>();
		map.put("ds_sido", request.getParameter("sido"));
		map.put("ds_gugun", request.getParameter("gugun"));
		AddrDAO dao = new AddrDAO();
		list = dao.selectDong(map);
		/* for (int i = 0; i < list.size(); i++) {
			out.print("<option>" + list.get(i) + "</option>");
		} */
	}

	out.print("<option>==선택==</option>");
	for (String str : list) {
		out.print("<option>" + str + "</option>");
	}
%>