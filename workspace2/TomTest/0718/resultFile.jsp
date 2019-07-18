<%@page import="java.io.FileWriter"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과페이지</title>
</head>
<%-- resultFile.jsp --%>
<body>
	<h3>결과 페이지</h3>
	<hr>
	이름 : <%=request.getParameter("username")%><br>
	파일 : <%=request.getParameter("myfile")%><br>
	<hr color="red">
	<%
		ServletInputStream sis = request.getInputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(sis, "UTF-8"));

		String delimiter = br.readLine(); //구분자역할을 하는 문자열
		//"------WebKitFormBoundarys29EFHDUPZj87Yvt"

		String str;
		int count = 0;
		while ((str = br.readLine()) != null) {
			count++;
			// out.print(str+"<br>");
			if (str.contains("name=\"myfile\"")) {
				System.out.println(count + "째줄에서 myfile을 찾았다!!");

				//파일명 찾기
				int startIdx = str.lastIndexOf("=") + 2;
				int endIdx = str.length() - 1;

				String fileName = str.substring(startIdx, endIdx);
				//"애국가.txt"
				FileWriter fw = new FileWriter(application.getRealPath("/upload/") + fileName);
				//e:/jaelee/workspace2/TomTest2

				br.readLine();
				br.readLine();//두줄 skip

				while ((str = br.readLine()) != null) {
					if (str.contains(delimiter))
						break;
					out.print(str + "<br>");
					fw.write(str+"\r\n");
				}
				
				fw.close();
			}

		}
		//애국가.txt파일의 내용을 브라우저 화면에 출력하자!!
		//애국가.txt파일을  upload폴더에 생성하고 내용을 파일출력하자!!
	%>
</body>
</html>