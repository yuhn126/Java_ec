<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<style type="text/css">
     body{text-align: center}
     table{margin: auto;}
     td{padding: 5px}
     .skyblue{background-color: skyblue;
              width: 80px;
              text-align: left}
 	 </style>
</head>

<body>
	<hr>
	<h3>방명록: 리스트</h3>
	<hr>
	<a href="form">방명록 쓰기</a>
	<%-- == "/TomTest/guest/control?action=form" --%>
	<br>
	<br>
	<form action="list" method="post">
		<table border="1">
			<tr bgcolor="tomato">
				<th>번호</th>
				<th>작성자</th>
				<th>전화번호</th>
				<th>작성일</th>
				<th>내용</th>
			</tr>

			<%--
			List<Guest>  list =   (List<Guest>)request.getAttribute("list");
			for(int i=0; i<list.size(); i++){
	        	Guest guest = list.get(i);
	        	out.print("<tr>");
	        	out.print("<td>"+guest.getNo()+"</td>");
	        	out.print("</tr>");
       		}
    		--%>

			<c:forEach items="${list }" var="guest">
				<tr>
					<td>${guest.no }</td>
					<td>${guest.writer }</td>
					<td>${guest.tel }</td>
					<td><fmt:formatDate value="${guest.wdate }" pattern="yyyy/MM/dd HH:mm:ss" /></td>
					<td><a href="/guest/upform?no=${guest.no}">${fn:substring(guest.contents,0,5)}..</a></td>
					<%--
						JSP(자바)요소 중 HTML또는 JavaScript와 어울릴 수 있는 요소는?
						==> 표현식(출력식)!!
						==> Expression <%= %>		Expression Language ${ }
					--%>
				</tr>
			</c:forEach>
		</table>
	</form>
	<br>
	<c:if test="${page == 1 }">
		이전
	</c:if>
	<c:if test="${page > 1 }">
		<a href="control?action=list&page=${page-1}">이전</a>
	</c:if>
	
	<c:forEach begin="1" end="${totalPage}" var='i'>
		<a href='control?action=list&page=${i }'>[${i }]</a>
	</c:forEach>
	
	<c:choose>
		<c:when test="${page < totalPage}">
			<a href="control?action=list&page=${page+1}">다음</a>
		</c:when>
		<c:otherwise>다음</c:otherwise>
	</c:choose>
	
	<a href="list?page=${page+1}&limit=${limit}">다음</a>
	
</body>
</html>