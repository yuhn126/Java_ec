<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="iba.MySqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
    addr_result.jsp
    ==> Ajax응답페이지
         ==> 부분HTML(데이터)역할
         
    <option>서울</option>
    <option>대구</option>
    <option>광주</option>
    <option>제주</option> 
 --%>

<%
   SqlMapClient smc = MySqlMapClient.getSqlMapInstance();
    String want = request.getParameter("want");    
    System.out.println("원하는 정보>>>"+ want);
    
    List<String> list=null;
    
    if(want==null || want.equals("sido")){//클라이언트(HTML)가  sido정보를 요청했다면
       list = smc.queryForList("addr.sido");
    }else if(want.equals("gugun")){//클라이언트(HTML)가  gugun정보를 요청했다면
    //List<String> list = smc.queryForList("addr.gugun","부산");
    //http://192.168.0.96/struts/0801/addr_result.jsp?sido=부산
      String sido = request.getParameter("sido");
      list = smc.queryForList("addr.gugun",sido);
      
    }else if(want.equals("dong")){
      String gugun = request.getParameter("gugun");	
      String sido = request.getParameter("sido");
      HashMap<String,String> map = new HashMap<>();
         map.put("gugun", gugun);
         map.put("sido", sido);
      list = smc.queryForList("addr.dong", map);
    }
    
    //for(변수선언:배열){
    	out.print("<option>==선택==</option>");
    for(String str:list){
    	out.print("<option>"+str+"</option>");
    }
%> 
   
   
   
   
   
   
   
    