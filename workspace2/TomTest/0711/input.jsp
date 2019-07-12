<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>입력페이지</title>
	</head>
	<%-- input.jsp --%>
	<body>
		<h3>input.jsp(데이터입력)</h3><hr>
		<form action="print.jsp" method="post">
			나이 : <input type="text" name="age"><br>
			이름 : <input type="text" name="name"><br>
			<button>전송</button><%-- <button>==<button type="submit"> --%>
		</form>
	</body>
</html>