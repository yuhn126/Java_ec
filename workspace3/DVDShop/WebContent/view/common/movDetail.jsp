<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%
	int i = 1;
	int j = 0;
	/* String loginId=null;
	if(session.getAttribute("loginId") != null){
		loginId = (String)session.getAttribute("loginId");
	} */
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${selectMov.movieTitle }</title>
		<link rel="stylesheet" href="../css/view.css" type="text/css">
		<script>
			var today = new Date();
	        var dd = today.getDate()+7;
	        var mm = today.getMonth()+1; //January is 0!
	        var yyyy = today.getFullYear();
	        
	        if(dd<10) {
	            dd='0'+dd
	        } 
	        if(mm<10) {
	            mm='0'+mm
	        } 
	        var tomorrow = yyyy+'년 ' + mm+'월 '+dd + '일';
		
			function rentalComfirm(id) {
				console.log(typeof(id));
				console.log(id);
				var rantalOk = confirm('대여하시겠습니까?');
				if(id == ''){
					alert('로그인하세요!');
					location.href="control?action=login";
				} else {
					if(rantalOk){
						alert('대여가 완료되었습니다.\n반납 예정일은 ' + tomorrow +"입니다.");
						location.href="control?action=movrental&movCode=${selectMov.movieCode }";
					}
				}
			}
		</script>
	</head>
	<%-- movDetail.jsp --%>
	<body>
	<form>
	<header>
		<h3>DVD Shop</h3>
	</header>
	<nav>
		<div id="nav">
			<%
				if (i > j) {
			%>
			<div id="userList">
				<%@ include file="usersList.jsp"%>
			</div>
			<%
				} else {
			%>
			<div id="managersList">
				<%@ include file="managersList.jsp"%>
				<%
					}
				%>
			</div>
		</div>
	</nav>
	<article>
		<table>
			<tr>
				<td><img width="350px" height="auto" src="${selectMov.image }"></td>
				<td>
				${selectMov.movieTitle }<br>
				감독 : ${selectMov.director }<br>
				출연자 : ${selectMov.actors }<br>
				장르 : ${selectMov.ganre }<br>
				등급 : ${selectMov.filmRate }세 관람가<br>
				상영시간 : ${selectMov.openingDate}<br>
				<c:if test="${selectMov.stock>0}">
					<input type="button" value="대여" onclick="rentalComfirm('${sessionScope.loginId}')"/>
				</c:if> 
				<c:if test="${selectMov.stock<=0}">
					<input type="button" value="대여불가" disabled/>
				</c:if>
				</td>
			</tr>
		</table>
	</article>
	</form>
	</body>
</html>