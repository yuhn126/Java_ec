<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호체크</title>
<script type="text/javascript">
	function checkpass() {
		//DB에 저장된 비번과 아래 폼에 입력된 비번을 비교!
		// - 만약 비번이 일치하지 않는 다면 '권한이 없습니다' 알림창!
		// - 만약 비번이 일치한다면 ----> open창 닫기, 계속(수정, 삭제)작업 진행

		//현재 문서 안에 작성된 비번 얻기
		var pass = document.passForm.pass.value;
		
		//DB에 저장된 비번 얻기
		var dpass = opener.document.editForm.dpass.value;
		if (pass !== dpass) {
			alert('권한이 없습니다!!');
			window.close();
		} else {
			//수정 또는 삭제 작업 실행!!
			opener.execUpDel();
			window.close();
		}
	}//checkPass
</script>
</head>
<body>
	<form name="passForm">
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