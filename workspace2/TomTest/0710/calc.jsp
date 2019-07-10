<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP계산기</title>
	</head>
	<body>
		<form action="result.jsp" method="post">
			<h3>JSP계산기</h3>
			<hr>
			<input type='text' size='5' name='su1'> 
			<select name='oper'>
				<option>+</option>
				<option>-</option>
				<option>*</option>
				<option>/</option>
			</select> <input type='text' size='5' name='su2'>
			<button type='submit'>계산</button>
		</form>
	</body>
</html>