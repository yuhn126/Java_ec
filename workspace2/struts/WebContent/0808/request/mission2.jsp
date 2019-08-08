<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mission2</title>
<script src="../../js/jquery-3.js"></script>
<script>
	$(function(){
		$('button').click(function() {
			$.ajax({
				url: '/struts/0808/mission2.do',
				data : {
					su1:$('input:eq(0)').val(),
					su2:$('input:eq(1)').val(),
					oper:$('[name=oper]').val()
				},
				success:function(data){
					$('div').html(data);
				}
			});
		});
	});
</script>
</head>
<body>
	<h3>스트럿츠 계산기</h3>
	<hr>
	<input type="text" size="4" name="su1">
	<select name="oper">
		<option selected>+</option>
		<option>-</option>
		<option>*</option>
		<option>/</option>
	</select>
	<input type="text" size="4" name="su2">
	<button>계산</button>
	<br>
	<div></div>
</body>
</html>