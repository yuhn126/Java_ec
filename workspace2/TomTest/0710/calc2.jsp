<%@page import="com.encore.t0709.Calculator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP계산기</title>
	</head>
	<body>
		<h3>JSP계산기</h3>
		<hr>
		<form method="post" action="calc2.jsp">
			<input type='text' size='5' name='su1'> 
			<select name='oper'>
				<option>+</option>
				<option>-</option>
				<option>*</option>
				<option>/</option>
			</select> <input type='text' size='5' name='su2'>
			<button type='submit'>계산</button>
		</form>
		<%
			//service()메소드 안에 들어갈 자바 코드!
			if (request.getMethod().equals("POST")) {
				String su1 = request.getParameter("su1");
				String su2 = request.getParameter("su2");
				String oper = request.getParameter("oper");
				if (su1.equals("") || su2.equals("")) {
					out.print("<font color='red'>데이터를 입력!</font>");
				} else if (!su1.matches("[\\d]+") || !su2.matches("[\\d]+")) {
					out.print("<font color='red'>숫자만 입력!</font>");
				} else if (oper.equals("/") && Integer.parseInt(su2) == 0) {
					out.print("<font color='red'>0으로 나눌 수 없습니다!</font>");
				} else {
					Calculator calc = new Calculator(Integer.parseInt(su1), Integer.parseInt(su2), oper);
					out.print("<hr><font color='blue'>" + calc.getResultStr() + "</font>");
				}
			}
		%>
	
	</body>
</html>