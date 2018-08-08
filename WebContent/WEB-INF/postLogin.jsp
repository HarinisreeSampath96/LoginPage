<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>${MESSAGE}</h3>
<form method="post" action="uploadFile.htm" enctype="multipart/form-data">
file selector:<input type="file" name="file">
<br>
<input type="submit" value="upload">
<br><h3>${MESSAGE1}</h3>

</form>
</body>
</html>