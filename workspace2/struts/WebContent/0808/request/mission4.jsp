<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>mission4</title>
		<script src="../../js/jquery-3.js"></script>
		<script>
			window.onload= function() {
				$.ajax({
					url: '../response/response4.jsp',
					success: function(data) {
						$('#select1').html(data);
					},
					data:{
						load:"sido"
					}
				});
			}
			
			function loadGugun() {
				$.ajax({
					url: '../response/response4.jsp',
					success: function(data){
						$('#select2').html(data);
					},
					data:{
						load : "gugun",
						sido : $('#select1').val()
					}
				});
			}
			
			function loadDong() {
				$.ajax({
					url: '../response/response4.jsp',
					success: function(data){
						$('#select3').html(data);
					},
					data:{
						load : "dong",
						sido : $('#select1').val(),
						gugun : $('#select2').val()
					}
				});
			}
		</script>
	</head>
	<body>
		<select id="select1" onchange="loadGugun(this)"></select>
		<select id="select2" onchange="loadDong(this)"></select>
		<select id="select3"></select>
	</body>
</html>