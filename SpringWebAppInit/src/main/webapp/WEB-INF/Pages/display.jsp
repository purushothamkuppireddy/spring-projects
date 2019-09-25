<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<td>Name</td>
<td>Mobile</td>
<td>password</td>
<td>Deletion</td>
<td>Updation</td>
</tr>
<c:forEach var="li" items="${Li}">
<tr>
<td>${li.name}</td>
<td>${li.mobile}</td>
<td>${li.password}</td>
<td><a href="delete/${li.mobile}">DELETE</a></td>
<td><a href="edit/${li.mobile}">EDIT</a></td>

</tr></c:forEach>


</table>

</body>
</html>