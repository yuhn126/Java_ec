<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<%-- calc_form.jsp --%>
<body>
	<form action="calc" method="post">
		<h3>계산기</h3>
		<hr>
		<input type='text' size='5' name='su1'> 
		<select name='oper'>
			<option>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</select> <input type='text' size='5' name='su2'>
		<button type='submit'>계산</button>
		<hr>
		${c }
	</form>
</body>
</html>