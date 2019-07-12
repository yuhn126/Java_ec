<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출력페이지</title>
</head>
<%-- 

print2.jsp ? id=gildong&pwd=1234&room=1강의실 


--%>
<body>
  <h3>(input2.jsp)폼안의 데이터 출력</h3>
  <hr>
  
  <% request.setCharacterEncoding("UTF-8"); %>
    아이디: <%= request.getParameter("id") %><br>
    비번: <%= request.getParameter("pwd") %><br>
    선택된과일: <%-- <%= request.getParameter("fruit") %> --%>
    <%
        //checkbox타입과 같이 동일한 name(<input name=fruit>)의 여러 선택값을 얻어오기.
      String [] fruits = request.getParameterValues("fruit");
      //만약, 선택된 checkbox가 한개도 없다면 fruits=null;
      
     if(fruits != null){//선택된 과일이 한개 이상
      for(int i=0; i<fruits.length; i++){
    	 out.print(fruits[i]+" "); 
      }
     }
    %>
    
    <br>
    강의실: <%= request.getParameter("room") %><br>
    히든: <%= request.getParameter("hide") %><br>
    파일: <%= request.getParameter("myfile") %><br>
    운동: <%= request.getParameter("sports") %><br>
    비고: <%= request.getParameter("note") %><br>
  <hr color="red">
  <%
     //만약, 폼안의 name속성의 값을 모를 경우?
     Enumeration<String> names =  request.getParameterNames();
     //["id","pwd","fruit","room","hide","myfile","sports","note"]
     
    while(names.hasMoreElements()){
         //out.print(names.nextElement()+"<br>");
        String name = names.nextElement();
        out.print(name +" : "+ request.getParameter(name)+"<br>");
    }
  
  %>
</body>
</html>






