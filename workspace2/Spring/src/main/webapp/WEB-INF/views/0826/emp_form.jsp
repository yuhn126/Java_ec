<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원폼</title>
</head>
<%-- emp_form.jsp --%>
<body>
	<form action="/Spring/emp/insert" method="post">
		<h3>사원 입력</h3><hr>
		사원 번호 : <input type="text" name="empno"><br>
		사원 이름 : <input type="text" name="ename"><br>
		급여 : <input type="text" name="sal"><br>
		부서 번호 : <input type="text" name="deptno"><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>