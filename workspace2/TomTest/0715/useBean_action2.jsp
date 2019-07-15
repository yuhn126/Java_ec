<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>정보 등록</title>
	</head>
	<%-- useBean_action2.jsp --%>
	<body>
		<h3>사람 정보 등록</h3><hr>
		<form action="insertProcess.jsp" method="post">
			이름 : <input type="text" name="name"><br>
			나이 : <input type="text" name="age"><br>
			직업 : <input type="text" name="job"><br>
			<input type="submit" value="등록">
		</form>
	</body>
</html>