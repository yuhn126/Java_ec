<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<ul>
	<li><a href="control?action=rentalList">대여 내역 확인</a></li>
	<li><a>회원 정보 수정</a></li>
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
