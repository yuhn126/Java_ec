<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- response5.jsp 
	 (JSON 출력) : {key1:value, key2:value}
	 				==> key1, key2는 변수!! value는 저장데이터
--%>
<%-- {name:'나길동', age:15, job: '학생'} --%>
{people:[{"name":"나길동", "age":"15", "job": "학생"},{"name":"길라임", "age":"17", "job": "청소년"},{"name":"김주원", "age":"19", "job": "학생"}]}
