<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>폼 전송 테스트</title>
	</head>
	<%-- 0725/form.jsp --%>
	<body>
		<h3>폼 전송 테스트</h3><hr>
		<form action="test.do" method="post">
			이름 : <input type="text" name="username"></br>
			나이 : <input type="text" name="userage"></br>
			<button>전송</button>
		</form>
	</body>
</html>