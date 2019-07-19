<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정폼</title>
</head>
<body>
	<h3>
		<strong>수정폼</strong>
	</h3>
	<hr>
	<a href="control?action=list">게시물 목록으로</a>
	<br>
	<br>
	<form action="control?action=update" method="post">
		<table border="1">
			<tr>
				<th bgcolor="#F5A9F2">작성자</th>
				<td>
					<input type="text" name="username" value="${vo.getWriter()}" disabled>
				</td>
			</tr>
			<tr>
				<th bgcolor="#F5A9F2">email</th>
				<td><input type="text" name="email" value="${vo.getEmail()}"></td>
			</tr>
			<tr>
				<th bgcolor="#F5A9F2">전화번호</th>
				<td><input type="text" name="tel" value="${vo.getTel()}"></td>
			</tr>
			<tr>
				<th bgcolor="#F5A9F2">비밀번호</th>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="8" cols="33" name="contents" >${vo.getContents() }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">
					<button>취소</button>
					<button>삭제</button></td>
			</tr>

		</table>
	</form>

</body>
</html>