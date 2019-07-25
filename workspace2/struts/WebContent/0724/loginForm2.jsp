<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인폼</title>
	</head>
	<%-- loginForm2.jsp --%>
	<body>
		<h3>로그인폼</h3>
		<hr>
		<%--
			현재 웹브라우저 URL : 'http://localhost/struts/0724/loginForm.do'
		--%>
		
		<%-- if(session.getAttribute("user") != null) { } --%>
		<logic:present scope="session" name="user">
			이미 로그인 하셨습니다.<br>
			사용자 정보 <br>
			사용자 이름 : <bean:write name="user" property="username"/> <br>
			전화번호 : ${user.phone} <br>
			이메일 : ${user.email} <br>
			<a href="/struts/0724/logout">로그아웃 하기</a>
			<html:link action="/0724/logout">로그아웃 하기</html:link>
		</logic:present> 
		
		<%-- if(session.getAttribute("user") == null) { } --%>
		<logic:notPresent scope="session" name="user">
			<b>로그인 하십시오.</b>
		</logic:notPresent>
		
		<form method="post" action="login.do">
			<%-- messages의 id속성은 변수! --%>
			<html:messages message="true" id="msg">
				<font color="tomato"><b><bean:write name="msg"/></b></font><br>
			</html:messages>
			
			아이디 : <input type="text" name="id">
			
				<%-- 'errid'키 값으로 저장된 메시지가 존재한다면 --%>
				<html:messages property="errid" id="msg">
					<font color="moccasin"><bean:write name="msg"/></font>
				</html:messages>
				<br>
				
			비밀번호 : <input type="password" name="pass">
				<html:messages property="errpass" id="msg">
					<font color="moccasin"><bean:write name="msg"/></font>
				</html:messages>
				<br>
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