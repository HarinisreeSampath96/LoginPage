<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page1</title>
</head>
<body>
<center>
<h1>Login Page</h1>
<form method="post" name="loginform"  action="login.htm">
Username :<input type="text" name="USERNAME"/><br> 
Password :<input type="password" name="PASSWORD"/><br> 
<input type="submit" value="login"><br>
<p>${MESSAGE}</p>
</form>
</center>

</body>
</html>