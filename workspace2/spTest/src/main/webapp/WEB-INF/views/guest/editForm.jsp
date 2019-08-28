<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>수정폼</title>
	<style type="text/css">
     body{text-align: center}
     table{margin: auto;}
     td{padding: 5px}
     .skyblue{background-color: skyblue;
              width: 80px;
              text-align: left}
 	</style>
 	<script src="/js/jquery-3.js"></script>
 	
	<script type="text/javascript">
		$(function(){
			$('button').click(function(){
				location.href="/guest/delete?no=+ ${param.no }";
			});
		});
	</script>
</head>
<body>
	<h3>
		<strong>수정폼</strong>
	</h3>
	<hr>
	<a href="list">게시물 목록으로</a>
	<br>
	<br>
	<form action="upform" method="post"
		name="editForm">
		<input type="hidden" name="dpass" value="${vo.pass }">
		<table border="1">
			<tr>
				<th bgcolor="#F5A9F2">작성자</th>
				<td><input type="text" name="username"
					value="${vo.writer}" readonly></td>
			</tr>
			<tr>
				<th bgcolor="#F5A9F2">email</th>
				<td><input type="text" name="email" value="${vo.email}"></td>
			</tr>
			<tr>
				<th bgcolor="#F5A9F2">전화번호</th>
				<td><input type="text" name="tel" value="${vo.tel}"></td>
			</tr>
			<tr>
				<th bgcolor="#F5A9F2">비밀번호</th>
				<td><input type="password" name="pass" value="${vo.pass}"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="8" cols="33" name="contents">${vo.contents }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="reset" value="취소">
					<!-- <input type="button" value="삭제" onclick="passCheck('del')"> -->
					<button>삭제</button>
				</td>
			</tr>

		</table>
	</form>
</body>
</html>