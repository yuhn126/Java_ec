<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.js"></script>
<script type="text/javascript">
	$(function () {
		$('#bbb').click(function() {
			alert('네이버')
			$('#frm').submit()
		})
	});
</script>
</head>
<body>
	<form id="frm" enctype="multipart/form-data" method="post">
		<input type="text">
		<button type="button" id="bbb">버튼</button>
	</form>
</body>
</html>