<%@page import="com.encore.t0715.Person"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- HTML태그이외의 커스텀태그(외부에서 정의된)를 사용하고 싶다. --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>jstl_test.jsp</title>
	</head>
	<%-- jstl_test.jsp --%>
	<body>
		<h3>JSTL(JSP Standard Tag Library)</h3><hr>
		<%
			//Controller에서 ArrayList로 저장된 데이터가 있다는 가정
			ArrayList<String> list = new ArrayList<>();
			list.add("나길동");
			list.add("차라임");
			list.add("정주원");
			list.add("김유신");
			
			request.setAttribute("nameList", list);//뷰(JSP)와 공유하기 위해
			
			
			ArrayList<Person> list2 = new ArrayList<>();
			list2.add(new Person("나길동",13,"학생"));
			list2.add(new Person("차라임",15,"학생"));
			list2.add(new Person("정주원",17,"학생"));
			
			request.setAttribute("personList", list2);
		
		%>
		<h3>이름목록</h3><hr>
		<ul>
		<c:forEach items="${ nameList }" var="name">
			<%-- items속성 안에 배열 데이터를 넣어주면 0인덱스 ~ length까지 반복
				 여기의 경우 var="name"  ==> String name = list.get(index);       --%>
			<li>${ name }
		</c:forEach>
		</ul>
		
		<hr>
		<table border="1" cellpadding="5">
			<tr bgcolor="moccasin">
				<th>이름</th><th>나이</th><th>직업</th>
			</tr>
			<c:forEach items="${personList }" var="p">
				<tr>
					<td>${p.name }</td>
					<td>${p.age }</td>
					<td>${p.job }</td>
				</tr>
			</c:forEach>
		</table>
		
		
		<hr color="moccasin">
		<h3>사람목록1(JSTL사용X)</h3>
		<%
			//request.setAttribute("personList", list2);
			ArrayList<Person> pList = (ArrayList<Person>)request.getAttribute("personList");
			for(int i=0; i<pList.size(); i++){
				Person p = pList.get(i);
				out.print("이름 : " + p.getName());
				out.print(", 나이 : " + p.getAge());
				out.print(", 직업 : " + p.getJob() + "<br>");
			}
		%>
		<hr color="green">
		<h3>사람목록2(JSTL사용O)</h3>
		<c:forEach items="${personList} " var="p">
			
		</c:forEach>
	</body>
</html>