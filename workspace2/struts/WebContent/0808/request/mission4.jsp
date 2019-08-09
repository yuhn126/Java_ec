<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>mission4</title>
		<script src="../../js/jquery-3.js"></script>
		<script>
			$(function(){
				$.ajax({
					url: '../response/response4.jsp',
					success: function(data) {
						$('#select1').html(data);
					},
					data:{
						load:"sido"
					}
				});
				
				$('#select1').change(function(){
					$.ajax({
						url: '../response/response4.jsp',
						success: function(data){
							$('#select2').html(data);
							$('#select3 option:eq(0)').attr("selected","selected");
						},
						data:{
							load : "gugun",
							sido : $('#select1').val()
						}
					});
				});
				
				
				$('#select2').change(function(){
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
				});
				
			});
			
		</script>
	</head>
	<body>
		<select id="select1"><option>==선택==</option></select>
		<select id="select2"><option>==선택==</option></select>
		<select id="select3"><option>==선택==</option></select>
	</body>
</html>