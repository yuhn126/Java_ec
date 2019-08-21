<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- test.jsp --%>
</head>
<body>
	<h3>날짜 입력</h3>
	<form>
	<fieldset>
		<legend>날짜종류</legend>
		제작년도 : <input type="text"><br>
		제작년도(연도 월 날짜) : <input type="date"><br>
		제작년도(연도 월) : <input type="month"><br>
		제작년도(연도 주) : <input type="week"><br>
		제작년도(시간) : <input type="time"><br>
		제작년도(날짜시간) : <input type="datetime-local"><br>
		<%-- 
			각 웹 브라우저에서 html태그 지원 여부
				==> http://html5test.com
		 --%>
	 </fieldset>
	 
	</form>
</body>
</html>