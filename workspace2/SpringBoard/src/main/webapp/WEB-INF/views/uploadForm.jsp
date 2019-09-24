<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload</title>
</head>
<%-- uploadForm.jsp --%>
<body>
	<form action="uploadformAction" method="post" enctype="multipart/form-data">
		<input type="file" name="uploadFile" multiple accept=".jpg,.jpeg,.gif,.bmp,.png"> <button>Submit</button>
	</form>
</body>
</html>