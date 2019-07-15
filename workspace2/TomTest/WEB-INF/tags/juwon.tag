<%@tag import="com.encore.t0715.Product"%>
<%@tag pageEncoding="utf-8" body-content="scriptless"%>

<%@  %>
<!--  WEB-INF/tags/juwon.tag (JSP문법과 흡사)
			저장파일명 == 태그명
	  ==> HTML + Java
 -->
 
<h3><jsp:doBody/></h3>
<%
	Product p = new Product();
	String []list = p.getProductList();
%>
<table border="1" bgcolor="yellow" cellpadding="5">
	<%
		for(int i = 0; i< list.length; i++){
			out.print("<tr><td>" + list[i] + "</td></tr>");		
		}
	%>
</table>

