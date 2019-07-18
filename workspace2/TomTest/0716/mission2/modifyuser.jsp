<%@page import="com.encore.t0716.UserInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="com.encore.t0716.UserInfo" scope="session" id="vo"/>
<%
	UserInfoDAO dao = new UserInfoDAO();
	vo = dao.selectModify((String)session.getAttribute("loginId"));
	String birthYear = vo.getBirth().substring(0, 4);
	String birthMonth = vo.getBirth().substring(5, 7);
	String birthDay = vo.getBirth().substring(8);
	
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사용자수정</title>
</head>
<body>
  <!-- <center> -->
  <form name="frm" action="modifyprocess.jsp" method="post">
  <table width="600" border="0" cellpadding="5" >
      <tr bgcolor="#3399cc">
         <td><font size="4" color="white">사용자정보수정</font>
      </tr>      
  </table>
  <table border="1" cellpadding="5" width="600">
      <tr>
         <td width="100" bgcolor="#ffcccc">사용자ID</td>
         <td colspan="3"> 
         <input type="text" name="id" value="<%= vo.getId() %>" disabled></td>
      </tr>
      <tr>
         <td width="100" bgcolor="#ffcccc">비밀번호</td>
         <td><input type="password" name="pass" value=<%= vo.getPass() %>> </td>
         <td width="100" bgcolor="#ffcccc">비번확인</td>
         <td><input type="password" name="pass2" value=<%= vo.getPass() %>> </td>
      </tr>
      <tr>
         <td width="100" bgcolor="#ffcccc">사용자이름</td>
         <td colspan="3">
         <input type="text" name="name" value="<%= vo.getName()%>" disabled>        
         </td>
         
      </tr>
      <tr>        
         <td width="100" bgcolor="#ffcccc">주민번호</td>
         <td colspan="3">            
              <input type="text" name="jumin1" size="6" maxlength="6"
                      style="height:23px" value=<%= vo.getJumin().substring(0, 6) %> disabled>
              -
              <input type="password" name="jumin2" size="7" maxlength="7"
                      style="height:23px" value=<%= vo.getJumin().substring(7)%> disabled></td>
      </tr>
      <tr>         
         <td width="100" bgcolor="#ffcccc" >생년월일</td>
         <td colspan="3">
         <input type="text" name="year" size="4" maxlength="4" value=<%= birthYear %>>년
         <select name="month">
         <%
         	for(int m=1; m<13; m++){
         		if(m == Integer.parseInt(birthMonth)){
         			if(m<10){
         				out.print("<option selected>0" + m + "</option>");
         			} else {
         				out.print("<option selected>" + m + "</option>");
         			}
         		} else {
         			if(m<10){
         				out.print("<option>0" + m + "</option>");
         			} else {
         				out.print("<option>" + m + "</option>");
         			}
         		}
         	}
         %>
         </select>월          
         <select name="day"> 
           <%
         	for(int d=1; d<32; d++){
         		if(d == Integer.parseInt(birthDay)){
         			if(d<10){
         				out.print("<option selected>0" + d + "</option>");
         			} else {
	         			out.print("<option selected>" + d + "</option>");
         			}
         		} else {
         			if(d<10){
         				out.print("<option>0" + d + "</option>");
         			} else {
         				out.print("<option>" + d + "</option>");
         			}
         		} 
         	}
         %>  
         </select>일          
          </td>
      </tr>
      <tr>
         <td width="100" bgcolor="#ffcccc" >우편번호</td>
         <td colspan="3">
            <input type="text" name="zip" size="5" maxlength="5" value=<%= vo.getZip() %>> 
            
	     </td>
      </tr>
      <tr>
         <td width="100" bgcolor="#ffcccc" >주소</td>
         <td colspan="3"><input type="text" name="addr" size="50" value=<%= vo.getAddr() %>></td>
      </tr>
      <tr>
         <td width="100" bgcolor="#ffcccc" >E-Mail</td>
         <td colspan="3"><input type="text" name="email" size="30" value=<%= vo.getEmail() %>>
          </td>
      </tr>
    
      <tr>
         <td width="100" bgcolor="#ffcccc">직업</td>
         <td colspan="3">
               <select name="job">
               <% 
                	String jobs[]={"==선택==","학생","공무원","언론/출판","군인/경찰","일반사무직",
        		   				"영업직","기술/전문직","보건/의료","자영업","주부","기타" };
               		for(int i=0; i < jobs.length; i++){
               			if(jobs[i].equals(vo.getJob())){
               				out.print("<option selected>" + jobs[i] + "</option>");
               			} else {
               				out.print("<option>" + jobs[i] + "</option>");
               			}
               		}
               	
               %>
               </select>
         </td>
      </tr>
      <tr align="center">
         <td colspan="4">
           <input type="submit" value="수정">
           <input type="reset" value="취소">
         </td>
      </tr>
  </table>
  </form>
 <!--  </center> -->
</body>
</html>