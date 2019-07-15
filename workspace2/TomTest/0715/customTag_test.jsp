<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- JSP1.2방식의 커스텀태그 --%>
<%@ taglib uri="/WEB-INF/tld/myTag.tld" prefix="my" %>

<%-- JSP2.0방식의 커스텀태그 --%>
<%@taglib tagdir="/WEB-INF/tags" prefix="you" %>

<%-- taglib지시어는 확장된 태그(커스텀태그)를 현재문서에서 사용하고자 할 때 기술 --%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>커스텀태그</title>
	</head>
	<%-- customTag_test.jsp --%>
	<body>
		<h3>커스텀태그 테스트</h3>
		<hr>
		<my:gildong/>
		<hr color="orange">
		<my:lime/>
		<hr color="green">
		<you:juwon>상품목록</you:juwon>
	</body>
</html>