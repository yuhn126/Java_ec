<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>구구단</title>
		<style type="text/css">
			/* CSS주석
			
			      태그이름{
					스타일명:스타일값;
					스타일명:스타일값
				 }
			*/
			table { 
				margin: auto; 
				border: 0
			}
			td {
				padding: 5px
			}
			h3 { text-align : center}
		</style>
	</head>
	<body>
		<h3>구구단</h3>
		<hr>
		<table>
			<%
				for (int j = 1; j < 10; j++) {
					out.print("<tr>");
					for (int dan = 2; dan < 10; dan++) {
						out.print("<td>" + dan + "*" + j + "=" + dan * j + "</td> ");
					}
					out.print("</tr>");
				}
			%>
		</table>
	
	</body>
</html>