<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>입력폼2</title>
	</head>
	<%-- inputFile.jsp --%>
	<body>
		<h3>입력폼(파일업로드 : cos.jar - MultipartRequest객체 사용)</h3>
		<hr>
		<form action="resultFile2.jsp" method="post"
			  enctype="multipart/form-data">
			이름: <input type="text" name="username"><br>
			파일: <input type="file" name="myfile"><br>
			<button>전송</button>
		</form>
	</body>
</html>