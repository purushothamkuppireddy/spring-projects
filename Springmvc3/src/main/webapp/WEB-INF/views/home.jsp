<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>WELCOME KR</h1>
<h2>${message}</h2>

<form action="welcomeuser" method="post">
NAME:<input type="text" name="uname"/><br>
<input type="submit" value="SUBMIT">

</form>
</body>
</html>