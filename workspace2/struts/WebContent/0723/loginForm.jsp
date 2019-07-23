<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인폼</title>
	</head>
	<%-- loginForm.jsp --%>
	<body>
		<h3>로그인폼</h3>
		<hr>
		<%--
			현재 웹브라우저 URL : http://192.168.0.35/struts/login/form.do
		 --%>
		
		<form method="post" action="login.do">
			아이디 : <input type="text" name="id"><br>
			비밀번호 : <input type="password" name="pass"><br>
			<input type="submit" value="로그인">
		</form>
		<%--
			<미션>
			현재 페이지(loginForm.jsp)를 struts-config.xml에 등록하여
			'/struts/login/form.do'URL요청시 웹브라우저에 출력하시오.
			
			==> <struts-config>
					<action-mappings>
						<action> 새로 생성
		 --%>
	</body>
</html>