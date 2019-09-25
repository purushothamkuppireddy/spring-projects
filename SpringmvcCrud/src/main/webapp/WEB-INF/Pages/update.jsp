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
Name:<input type="text" name="name" value="${u.name}"/><br>
<input type="hidden" name="mobile" value="${u.mobile}"><br>
Email:<input type="text" name="email" value="${u.email}"><br>
<button (click)>SUBMIT</button>
</form>
</body>
</html>