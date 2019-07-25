<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>계산기</title>
		<style type="text/css">
			body {
				text-align: center;
			}
		</style>
	</head>
	<%-- calc.jsp --%>
	<body>
		<form action="calc.do" method="post">
			<h3>스트럿츠 계산기</h3><hr>
			<input type="text" size="4" name="su1">
			<select name="oper">
				<option>+</option>
				<option>-</option>
				<option>*</option>
				<option>/</option>
			</select>
			<input type="text" size="4" name="su2">
			<button type='submit'>계산</button>
			
			<logic:present scope="session" name="result">
				<hr><font color="blue">${result }</font>
				<% session.removeAttribute("result"); %>
			</logic:present>
			<html:messages property="errcalc" id="msg">
				<br>
				<font color="red"><bean:write name="msg"/></font>
				
			</html:messages>
			<br>
		</form>
	</body>
</html>