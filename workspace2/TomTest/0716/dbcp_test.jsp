<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DBCP(DataBase Connection Pool)테스트</title>
	</head>
	<%-- dbcp_test.jsp --%>
	<body>
		<h3>DBCP(DataBase Connection Pool)테스트</h3>
		<hr>
		<form method="post">
			사번 : <input type="text" name="empno">
			<input type="submit" value="검색">
		</form>
		<hr>
		<%
		
		/*
			※객체 등록, 조회, 삭제 ---------> Context
												 ctx
			<객체 등록>
			ctx.bind("이름", 객체);
				
				
				         key		   value
			예) ctx.bind("p1", new Person("홍길동",13));
			    ctx.bind("p1", new Person("길라임",15));
			    	---> 에러 발생! (같은 키 값 사용 불가)
			    
			    ctx.rebind("이름", "객체");
			    ctx.rebind("p1", new Person("길라임",15));
			    	---> 등록성공!
			    	
			    ctx.bind("jdbc/oracle", new DataSource());
			    	
			    	
			<객체조회>
			Object ctx.lookup("이름");
			 
			예) Person p = (Person)ctx.lookup("p1");
				DataSource ds = ctx.lookup("jdbc/oracle");
				
				
			<객체삭제>
			ctx.unbind("이름");
			
			예) ctx.unbind("p1");
			
			RMI 프로토콜
		*/
		if(request.getMethod().equals("POST")){ //"GET", "POST"
			//폼 내의 '검색'버튼을 클릭했다면
			Context ctx = new InitialContext();
		
			//톰캣 서버가 갖는 환경관련 Context 얻기
			Context tomCtx = (Context)ctx.lookup("java:comp/env");
			
			DataSource ds = (DataSource)tomCtx.lookup("jdbc/oracle");
			//ds == 커넥션 풀!
					
			Connection conn = ds.getConnection();
			//커넥션 풀 내의 미리 생성된(준비)된 Connection요청(주소 얻어오기)
			
			System.out.println("DB연결 성공^0^");
			String empno = request.getParameter("empno");
			
			String sql = "select ename from emp where empno = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(empno));
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){ //사번에 일치하는 사원명을 찾았다면
				out.print(empno + "사번은 [" + rs.getString("ename") + "]사원입니다.");
			} else {
				out.print("<font color='tomato'>" + empno + "사번이 존재하지 않습니다. </font>");
			}
			
		}//if 요청방식 == POST
		
		%>
	</body>
</html>