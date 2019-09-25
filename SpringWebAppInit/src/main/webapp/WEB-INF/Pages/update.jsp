<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="../update">
<input type="hidden" name="name" value="${u.name}"/><br>
Mobile<input type="text" name="mobile" value="${u.mobile}"><br>
Password:<input type="text" name="password" value="${u.password}"><br>
<button (click)>SUBMIT</button>
</form>
</body>
</html>