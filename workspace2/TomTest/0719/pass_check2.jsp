<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>비밀번호체크</title>
		<script type="text/javascript">
			if('${result}' === 'incorrect'){
				alert('권한이 없습니다.');
				window.close();
			} else if ('' === 'correct'){
				opener.execUpDel();
				window.close();
			}
		</script>
	</head>
	<% session.removeAttribute("result"); %>
	<body>
		<form name="passForm" action="control?action=passcheck" method="post">
			<table>
				<tr>
					<td bgcolor="tomato">비밀번호</td>
					<td><input type="password" name="pass"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="확인" onclick="checkpass()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>