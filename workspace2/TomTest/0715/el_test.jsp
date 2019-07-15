<%@page import="com.encore.t0715.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EL테스트</title>
	</head>
	<%-- el_test.jsp --%>
	<body>
		<h3>EL(표현언어 = 출력언어)테스트</h3>
		<%
			//영역에 데이터 저장 ---> MVC에서는 주로 Controller가 담당!
			//영역객체.setAttribute(string key, Object value);
			pageContext.setAttribute("k1", "홍길동");
			request.setAttribute("k2", "김라임"); //자주사용
			session.setAttribute("k3", "김주원"); //자주사용
			application.setAttribute("k4", "대한민국");
			
			request.setAttribute("k5", new Person("김유신", 14, "화랑"));
			session.setAttribute("k5", "송혜교");
			application.setAttribute("k5", "송중기");
			int su=33;
		%>
		<h3>ExpressionLanguage(표현언어EL=출력언어)테스트</h3>
		<hr>
		k1 : <%= pageContext.getAttribute("k1") %><br>
		k2 : <%= request.getAttribute("k2") %><br>
		k3 : <%= session.getAttribute("k3") %><br>
		k4 : <%= application.getAttribute("k4") %><br>
		k5(request) : <%= request.getAttribute("k5") %><br>
		k5(session) : <%= session.getAttribute("k5") %><br>
		k5(application) : <%= application.getAttribute("k5") %><br>
		지역변수 su : <%= su %><br>
		존재하지 않는 k6 : <%= request.getAttribute("k6") %><br>
		
		<hr color="tomato">
		k1 : ${k1} <br>
		k2 : ${k2} <br>
		k3 : ${k3} <br>
		k4 : ${k4} <br>
		k5 : ${k5} <br><font color="red">영역 구분 없이 키 값만 출력하면 <br>
					page, request, session, application순으로 가장 가까운 데이터 출력 </font><br>
		k5(request) : ${ requestScope.k5 }<br>
		k5(session) : ${ sessionScope.k5 }<br>
		k5(application) : ${ applicationScope.k5 }<br>
		su(영역객체X, 지역변수) : ${su}<font color="blue">지역변수는 사용 불가<br>
											su를 키값으로 인식</font><br>
		k6(정의되지 않은 키 값) : ${k6}<font color="blue">없는 키 값은 빈 문자열 출력</font><br>
		
		
		<hr color="moccasin">
		<h3>입력폼</h3>
		<form action="print.jsp">
			이름 : <input type="text" name="username">
			나이 : <input type="text" name="userage">
			<button type="submit">submit</button>
		</form>
	
	</body>
</html>