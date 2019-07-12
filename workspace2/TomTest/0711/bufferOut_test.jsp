<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    buffer="8kb"
    autoFlush="true"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>bufferOut_test</title>
	</head>
	<%-- bufferOut_test.jsp --%>
	<body>
		<h3>out(buffer)객체 테스트</h3><hr>
		<%
			//out : 브라우저 출력 객체 [서블릿 : PrintWriter, JSP : JspWriter]
			out.print("현재 버퍼의 크기 : " + out.getBufferSize());
			out.print("<br>버퍼의 남은 양 : " + out.getRemaining());
			
		%>
	</body>
</html>