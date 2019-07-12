<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- start.jsp(요청페이지)  --%>
<body>
	<h3>start.jsp(요청페이지, 영역객체, 영역데이터 테스트)</h3>
	<%
		//데이터를 영역(page < request < session <  application)에 저장

		//pageContext.setAttribute(String key, Object value);
		String name = "홍길동";
		pageContext.setAttribute("k1", name);//현재페이지 에서만 공유

		request.setAttribute("k2", "길라임");//요청관계에 있는 페이지간 공유

		session.setAttribute("k3", "김주원");//동일브라우저(동일접속)내에서 공유
		session.setAttribute("k3", "나주원");//동일브라우저(동일접속)내에서 공유
		//동일 영역에 같은 키값을 갖는다면 뒤에 정의된 값으로 덮어쓰기
		//(키값은 유일해야 함)

		application.setAttribute("k4", "항상 즐거운 일 가득하세요~^^*");//동일서버(Tomcat)에서의 공유
		application.setAttribute("k3", "이순신");//동일서버(Tomcat)에서의 공유
		//영역이 다를 때는 키값이 덮어쓰기가 되지 않음
		//session의 k3키와  application의 k3키는 서로 다른 키값. 

		//out.print("k1저장데이터: "
		//	   + pageContext.getAttribute("k1"));
		out.print("이름데이터: " + name);

		//==============페이지 이동!!(1.forward, 2.redirect)===================
		//request.getRequestDispatcher("이동할 경로");
		RequestDispatcher rd = request.getRequestDispatcher("/0711/end.jsp");
		//rd.forward(ServletRequest arg0, ServletResponse arg1);
		rd.forward(request, response);

		//response.sendRedirect("end.jsp");
	%>
</body>
</html>






