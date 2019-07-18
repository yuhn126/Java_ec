<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>결과페이지</title>
	</head>
	<%-- resultFile2.jsp --%>
	<body>
		<h3>결과페이지(파일업로드)</h3>
		<%
			//MultipartRequest(HttpServletRequest request, String SaveDirctory)
			//MultipartRequest(HttpServletRequest request, String SaveDirctory, String encoding)
			//MultipartRequest(HttpServletRequest request, String SaveDirctory, 
			//					int maxPostSize, String encoding, FileRenamePolicy policy)
			
			String saveDir = application.getRealPath("/upload");
			//--> "E:/hnyu/workspace2/TomTest/upload"
			int maxSize = 5 * 1024 * 1024; //업로드 될 파일의 크기 제한, 단위 : byte
			//          5byte  5kb    5mb
			MultipartRequest mreq = new MultipartRequest(request, saveDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
			//MultipartRequest생성자 호출 == 파일 업로드!
					
			out.print("파일 업로드 성공!");
			String name = mreq.getParameter("username");
		%>
		<br>
		이름 : <%= name %><br>
		원본파일명 : <%= mreq.getOriginalFileName("myfile") %><br>
		저장파일명 : <%= mreq.getFilesystemName("myfile") %><br>
	</body>
</html>