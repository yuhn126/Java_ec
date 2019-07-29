<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--news.jsp (Ajax요청에 대한 부분HTML 응답) --%>
<%
   String []newsList = {"서울‧경기일부, 호우특보 해제..밤부터 다시 매우 강한 비",
		   "교육부 '상산고 자사고 취소' 제동 왜?..사회통합전형지표 위법",
		   "靑수석 3명 교체..민정 김조원·일자리 황덕순·시민사회"};
   for(int i=0; i<newsList.length; i++){
	   if(i==0)out.print("<strong>"+newsList[i]+"</strong>");
	   else out.print(newsList[i]);
	   out.print("<br>");
   }
%>


