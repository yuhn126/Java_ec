<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="../../js/jquery-3.js"></script>
		<script>
			$(function() {
				$('button').click(function() {
					$.ajax({
						url:'/struts/0808/mission3.do',
						data : {
							checked : $('[name=search]:checked').val(),
							value : $('input:eq(2)').val()
						},
						success: function(data){
							$('div').html(data)
						}
					});
				});
			});
		</script>
	</head>
	<body>
		<input type='radio' name="search" value="ename" checked>사원명
		<input type='radio' name="search" value="deptno">부서번호<br>
		<input type='text'><br>
		<button>검색</button>
		<div></div>
	</body>
</html>