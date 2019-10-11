<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력폼</title>
</head>
<%--inputForm.jsp --%>
<body>
	<h3>입력폼</h3>
	<hr>
	<form>
		제목:<input type="text" name="title"><br>
		내용:<textarea rows="5" cols="20" name="content"></textarea><br>
		작성자:<input type="text" name="writer"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>