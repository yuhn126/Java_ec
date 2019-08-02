<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.encore.util.Util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- reply_list.jsp (댓글 전체 목록 출력)
	 ==> Ajax요청에 대한 응답페이지(부분HTML 또는 text)
	    ------
	    JavaScript요청!
	    
	{no:1, name:'홍길동', content:'첫 댓글'},
	{no:2, name:'길라임', content:'나도 댓글'},
	{no:3, name:'김주원', content:'너도 댓글'}
--%>
[
<c:forEach items="${list }" var="reply" varStatus="stat">
	{no: ${reply.no }, name:'${reply.name }', content:'${Util.toJS(reply.content) }'}
	<c:if test="${stat.count < list.size()}">,</c:if>
</c:forEach>
]