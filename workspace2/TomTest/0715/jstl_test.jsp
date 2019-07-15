<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<%-- jstl_test.jsp --%>
	<body>
		<h3>JSTL(JSP Standard Tag Library)테스트</h3><hr>
		<%-- <% if(조건식){} %> --%>
		<c:if test="true">
			HTML마크업, text <br>
			조건식 참 일때 실행<br>
		</c:if>
		
		<c:if test="some text">
			some text
		</c:if>
		
		<c:if test="${2<3 }">
			2는 3보다 작다<br>
		</c:if>
		
		<%-- 나이테스트 --%>
		<c:if test="${param.age < 20 }">
			<font color="blue">나이가 20미만입니다.</font><br>
		</c:if>
		
		<c:if test="${param.age >= 20 }">
			<font color="blue">나이가 20이상입니다.</font><br>
		</c:if>
		
		<c:if test="${param.age >= 20 && param.age < 30 }">
			<font color="blue">나이가 20대입니다.</font><br>
		</c:if>
		<hr>
		
		<%-- 나이 20대, 30대 체크 --%>
		<c:choose>
			<c:when test="${param.age < 20 || param.age > 39} ">
				<font color="green">나이가 20대 또는 30대가 아닙니다.</font>
			</c:when>
			<c:when test="${param.age < 30 }">
				<font color="green">나이가 20대입니다.</font>
			</c:when>
			<c:otherwise>
				<font color="green">나이가 30대입니다.</font>
			</c:otherwise>
		</c:choose>
		<hr>
		<h4>forEach테스트</h4>
		<%-- JSTL안녕!! 홀수줄은 빨강, 짝수줄은 파랑 출력 하시오 --%>
		<c:forEach begin="0" end="10" var="i" varStatus="stat" step="1">
			인덱스 : ${stat.index}, 카운트 : ${stat.count } 
			JSTL안녕! ==> ${i }<br>
		</c:forEach>
		<hr>
		<c:forEach begin="0" end="10" var="i" varStatus="stat" step="1">
			<c:if test="${stat.count %2 == 0 }">
				<font color="blue">JSTL안녕! ==> ${i }</font><br>
			</c:if>
			<c:if test="${stat.count %2 == 1 }">
				<font color="red">JSTL안녕! ==> ${i }</font><br>
			</c:if>
		</c:forEach>
		
	</body>
</html>




