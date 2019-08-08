<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>mission1</title>
		<script src="../../js/jquery-3.js"></script>
		<script>
			$(function(){
				$('button').click(function(){
					$.ajax({
						url : '/struts/mission1.do',
						data : {username:$('#username').val()},
						success : function(data){
							$('div').html("안녕, " + data + "!!");
						}
					});
				});
			});
		</script>
	</head>
	<body>
		이름 : <input type="text" id="username" size="10">
		<button>전송</button>
		<div></div>
	</body>
</html>