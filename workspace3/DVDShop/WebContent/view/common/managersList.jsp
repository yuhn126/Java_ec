<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<ul>
	<li>영화 관리</li>
	<li>회원 관리</li>
</ul>
<br>
<%
	if (request.getSession().getAttribute("loginCode") == null) {
%>
<input type="button" value="회원가입"
	onclick="location.href='control?action=join'" />
<input type="button" value="로그인"
	onclick="location.href='control?action=login'" />
<%
	} else {
%>
<input type="button" value="로그아웃"
	onclick="location.href='control?action=logout'" />
<%
	}
%>
