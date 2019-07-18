<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript">
		function birthCh(){
			var jumin1 = document.frm.jumin1.value;//'960302'
			var birthYear = jumin1.substr(0, 2); //'96'
			var ch = document.frm.jumin2.value.charAt(0); //'1012345' ==> '1'
			
			if (ch == '1' || ch == '2' || ch == '5' || ch == '6') {
				birthYear = '19' + birthYear;
			} else { //ch = '3' '4' '5' '6'
				birthYear = '20' + birthYear;
			}
			
			document.frm.year.value = birthYear;
			document.frm.month.value = jumin1.substr(2, 2);
			document.frm.day.value = jumin1.substr(4, 2);
		}
		
		function ckid(){
			var id = document.frm.id.value;
			if(id == ''){
				alert('아이디를 입력!');
				return;
			}
			window.open('confirmid.jsp?id='+ id,'confirm',
	    			  'toolbar=no,location=no,status=no,'
	    			  +'menubar=no,scrollbars=no,resizable=no,'
	    			  +'width=300,height=200,top=200,left=300');
		}
		
		function vaildateCheck(){
			var f = document.frm; // f==폼 엘리먼트 객체
			
			//정규식 정의
			var jumin1Exp = new RegExp("^[\\d]{6}$");
			var jumin2Exp = /^[\d]{7}$/;
			var yearExp = /^[\d]{4}$/;
			var zipExp = /^[a-zA-Z0-9]{5}$/;
			var idExp = /^[a-zA-Z0-9]{6,20}$/;
			var emailExp = /^[a-zA-Z0-9]+@[a-zA-Z]+\.[a-zA-Z]+$/;
			
			
			if(!idExp.test(f.id.value)){
				alert('아이디는 6~20자리!');
				f.id.focus();
			} else if (f.pass.value=="") {
				alert('비번입력!');
				f.pass.focus();
			} else if (f.pass2.value==""){
				alert('비번입력!');
				f.pass2.focus();
			} else if(f.pass.value != f.pass2.value){
				alert('비번이 일치하지 않습니다.');
				f.pass.value="";
				f.pass2.value="";
				f.pass.focus();
			} else if(f.name.value=="") {
				alert('이름 입력!');
				f.name.focus();
			} else if (!jumin1Exp.test(f.jumin1.value) || !jumin2Exp.test(f.jumin2.value)) {
				alert('잘못된 주민번호입니다.');
				f.jumin1.value='';
				f.jumin2.value='';
				f.jumin1.focus();
			} else if (!zipExp.test(f.zip.value)) {
				alert('잘못된 우편번호입니다.');
				f.zip.value='';
				f.zip.focus();
			} else if (!emailExp.test(f.email.value)){
				alert('잘못된 이메일입니다.');
				f.email.value='';
				f.email.focus();
			} else if(f.job.value == '==선택=='){
				alert('직업을 선택!!');
				f.job.focus();
			}else{
				//올바른, 프로그램에서 원하는 데이터 입력시
				f.submit();
			}
		}
	</script>
<title>사용자등록</title>
</head>
<%-- userinput.jsp --%>
<body>
	<center>
		<form name="frm" action="userprocess.jsp" method="post">
			<table width="600" border="0" cellpadding="5">
				<tr bgcolor="#3399cc">
					<td><font size="4" color="white">사용자정보입력</font>
				</tr>
				<tr>
					<td>안녕하세요. 이 페이지를 자유롭게 이용하려면 먼저 회원가입을 하셔야 합니다.<br> 아래의
						사항들을 빠짐없이 기록해 주세요.
					</td>
				</tr>
			</table>
			<table border="1" cellpadding="5" width="600">
				<tr>
					<td width="100" bgcolor="#ffcccc">사용자ID<font color="red">*</font></td>
					<td colspan="3">
						<input type="text" name="id">
						<input type="button" value="중복확인" onclick="ckid()">
						<font color="blue">(6자리~12자리)</font>
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">비밀번호<font color="red">*</font></td>
					<td><input type="password" name="pass"></td>
					<td width="100" bgcolor="#ffcccc">비번확인</td>
					<td><input type="password" name="pass2"></td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">사용자이름<font color="red">*</font></td>
					<td colspan="3"><input type="text" name="name"></td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">주민번호<font color="red">*</font></td>
					<td colspan="3">
						<input type="text" name="jumin1" size="6" maxlength="6" style="height: 23px" > 
						- 
						<input type="password" name="jumin2" size="7" maxlength="7" style="height: 23px" onblur="birthCh()">
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">생년월일</td>
					<td colspan="3">
						<input type="text" name="year" size="4" maxlength="4">년 
						<select name="month">
						<%
							for (int m = 1; m < 13; m++) {
								if(m < 10){
									out.print("<option>0" + m + "</option>");
								} else {
									out.print("<option>" + m + "</option>");
								}
							}
						%>
						</select>월 
						<select name="day">
						<c:forEach begin="1" end="31" var="i">
							<c:if test="${i<10}"><option>0${i}</option></c:if>
							<c:if test="${i>9}"><option>${i}</option></c:if>
						</c:forEach>
						<%-- <%
							for (int d = 1; d <= 31; d++) {
								if(d < 10){
									out.print("<option>0" + d + "</option>");
								} else {
									out.print("<option>" + d + "</option>");
								}
							}
						%> --%>
						</select>일
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">우편번호<font color="red">*</font></td>
					<td colspan="3"><input type="text" name="zip" size="5"
						maxlength="5"></td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">주소</td>
					<td colspan="3"><input type="text" name="addr" size="50"></td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">E-Mail<font color="red">*</font></td>
					<td colspan="3"><input type="text" name="email" size="30"></td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">직업<font color="red">*</font></td>
					<td colspan="3">
						<select name="job">
							<%
								String jobs[] = { "==선택==", "학생", "공무원", "언론/출판", "군인/경찰", "일반사무직", "영업직", "기술/전문직", "보건/의료", "자영업", "주부",
										"기타" };
								/* for(int i=0; i < jobs.length; i++){
									out.print("<option>" + jobs[i] + "</option>");
								} */
								pageContext.setAttribute("list", jobs);
							%>
							<c:forEach items="${list }" var="jobName">
								<option>${jobName }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="center">
					<td colspan="4">
						<input type="button" value="등록" onclick="vaildateCheck()"/>
						<input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>