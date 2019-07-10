<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>안녕</title>
	</head>
	<body>
		<font color="tomato" size="12">안녕, JSP!</font><br>
		<script type="text/javascript">
			document.write("나는 자바스크립트^O^");
		</script>
		<%!
			int su;
			int su2 = 200;
			
			public String getMsg(){
				return "건강최고~!";
			}
		%>
		<%
			out.print("<br>나는 JAVA^O^~!!");
			System.out.println("나는 콘솔 출력^O^!");
			su=100;
		%>
		<%= 2+3 %>
		<%= getMsg() %>
	</body>
</html>
