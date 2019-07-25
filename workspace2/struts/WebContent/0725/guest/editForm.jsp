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
	<script type="text/javascript">
		var choice;
		
		function passCheck(updel) {
			choice = updel;
			window.open('passForm.do?no=${param.no}', 'confirm',
					'width=450, height=200, top=100, left=200');
		}
		//location.href='control?action=delete&no=${ vo.getNo()}'
	
		function execUpDel() {
			//수정처리
			if(choice == 'up'){
				if(document.editForm.pass.value == ""){
					document.editForm.pass.value = ${guest.getPass()}
				}
				document.editForm.submit();
			}
			//삭제처리
			else {//if(choice == 'del')
				location.href = 'delete.do?no=${param.no}'
			}
		}
	</script>
</head>
<body>
	<h3>
		<strong>수정폼</strong>
	</h3>
	<hr>
	<a href="list.do">게시물 목록으로</a>
	<br>
	<br>
	<form action="update.do?no=${guest.getNo()}" method="post"
		name="editForm">
		<input type="hidden" name="dpass" value="${guest.getPass() }">
		<table border="1">
			<tr>
				<th bgcolor="#F5A9F2">작성자</th>
				<td><input type="text" name="username"
					value="${guest.getWriter()}" readonly></td>
			</tr>
			<tr>
				<th bgcolor="#F5A9F2">email</th>
				<td><input type="text" name="email" value="${guest.getEmail()}"></td>
			</tr>
			<tr>
				<th bgcolor="#F5A9F2">전화번호</th>
				<td><input type="text" name="tel" value="${guest.getTel()}"></td>
			</tr>
			<tr>
				<th bgcolor="#F5A9F2">비밀번호</th>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="8" cols="33" name="contents">${guest.getContents() }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="수정" onclick="passCheck('up'), modPass()">
					<input type="reset" value="취소">
					<input type="button" value="삭제" onclick="passCheck('del')">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>