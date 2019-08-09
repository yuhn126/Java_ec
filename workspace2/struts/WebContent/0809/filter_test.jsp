<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>jQuery-filter테스트</title>
		<style>
			table {
			  font-family: arial, sans-serif;
			  border-collapse: collapse;
			  width: 100%;
			}
			
			td, th {
			  border: 1px solid #dddddd;
			  text-align: left;
			  padding: 8px;
			}
			
			tr:nth-child(even) {
			  background-color: #dddddd;
			}
		</style>
		
		<script src="../js/jquery-3.js"></script>
		<script>
			$(function() {
				$('input[name=search]').keyup(function() {
					var search = $(this).val().toUpperCase();
					$('#myTable tr').filter(function() {
						var txt = $(this).text().toUpperCase();
						console.log(txt);
						//toggle() - 번갈아 실행 : show() 또는 hide() 실행
						//엘리먼트.toggle(true)    ---> 엘리먼트 보이기
						//엘리먼트.toggle(false)   ---> 엘리먼트 숨기기
						
						//  var str='gildong'
			            //           0123456
			            //  str.indexOf('g')  ---> 0
			            //  str.indexOf('d')  ---> 3
			            //  str.indexOf('x')  ---> -1
			            
			            //$('선택자').toggle(true);//보이기 설정
						$(this).toggle(txt.indexOf(search) > -1);
					})
				});
			});
		</script>
	</head>
	<%-- filter_test.jsp --%>
	<body>
		<h3>filter테스트</h3><hr>
		<input type="text" name="search" placeholder="검색어"><br>
		<table>
			<!-- 그룹설정(thead, tbody(여러개 사용 가능), tfood(총합계 등의 결과 출력) -->
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody id="myTable">
				<tr>
					<td>HongGilDong</td>
					<td>29</td>
					<td>gildong@hanmail.net</td>
				</tr>
				<tr>
					<td>GilLaIm</td>
					<td>26</td>
					<td>lime@naver.com</td>
				</tr>
				<tr>
					<td>KimJuWon</td>
					<td>18</td>
					<td>juwon@nate.com</td>
				</tr>
				<tr>
					<td>KimYooSin</td>
					<td>28</td>
					<td>yoosin@naver.com</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>