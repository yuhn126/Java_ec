<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--suggest.jsp(제시어 응답데이터 출력) --%>
<%!
   String []keywords={"자바","자전거","자동차","자소서","자메이카",
		   "자라","자석","자기소개서","자연휴양림","자바라",
		   "abc마트","ajax","apple","aoa","apartment","axa다이렉트",
		   "aia","a4용지"};

   public List<String> search(String keyword){//keyword:HTML전달 받은 데이터
	   List<String> resultList = new ArrayList<>();
   
       //사용자가 입력한 데이터(keyword)를 배열과 비교해서 keyword로 시작하는 단어만
       //resultList에 추가!!
       
       //"javaProgramming".startsWith("ja");  ---> true
       //"javaProgramming".startsWith("ing");  ----> false
       //"javaProgramming".endsWith("ing");  ----> true
       //"javaProgramming".contains("Pro");  ----> true
       
       if(keyword==null || keyword.equals("")){
    	   return resultList;//size가 0인 List리턴!!
       }
       
       for(int i=0; i<keywords.length; i++){
    	   if(keywords[i].startsWith(keyword)){
    		   resultList.add(keywords[i]);
    	   }
       }
       
       return resultList;
   }//search
%>
<%
      //System.out.println("제시어 요청이 있었네~!!");
      String keyword = request.getParameter("keyword");
      List<String> list = search(keyword);
      
      out.print(list.size()+"|");
      for(int i=0; i<list.size(); i++){
    	  out.print(list.get(i));
    	  if(i < list.size()-1)out.print(",");
      }
%>