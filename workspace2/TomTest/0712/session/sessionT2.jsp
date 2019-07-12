<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title>사용자 인증</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">
	.normal {
		font-family: "굴림", "돋움";
		font-size: x-small;
		font-style: normal;
		font-weight: normal;
		text-decoration: none
	}
	
	.normalbold {
		font-family: "굴림", "돋움";
		font-size: x-small;
		font-style: normal;
		font-weight: bold;
		text-decoration: none
	}
	</style>
	</head>
	<%-- sessionT2.jsp --%>
	<%
		/*
			로그인폼에 입력된 아이디와 비밀번호를 검사(인증)
			--> DB비교
				---> 일치(id존재, pass일치)경우 : 밑의 HTML출력
				---> 불일치 경우 : 로그인 페이지 이동
		*/
	
		HashMap<String, String> map = new HashMap<>(); //map == DataBase
		//key : 아이디, value : 패스워드
		//데이터 저장!
		map.put("gildong", "1234");
		map.put("lime", "5678");
		map.put("juwon", "3333");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		String dpass = map.get(id);		
		if(dpass == null){ //아이디가 존재하지 않는다면
			//로그인 폼으로 이동
			response.sendRedirect("sessionT1.jsp");
		} else {//아이디가 존재한다면
			if(dpass.equals(pass)){ //아이디 존재, 비번 일치
				//로그인 성공!! ---> 세션 부여!
				session.setAttribute("login", "success");
			} else { //아이디 존재, 비번 불일치
				response.sendRedirect("sessionT1.jsp");
			}
		}
		
	%>
	
	<body>
		<center>
			<p class="normalbold">사용자 인증 완료</p>
			<p class="normal">
				<a href="sessionT3.jsp">서비스페이지</a>
			</p>
		</center>
	</body>
</html>