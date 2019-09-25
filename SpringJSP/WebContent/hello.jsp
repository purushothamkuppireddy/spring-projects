<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <%int num1=Integer.parseInt(request.getParameter("a"));
 int num2=Integer.parseInt(request.getParameter("b"));
 int sum=num1+num2;
 if(sum%2==0)
 {
	 out.print("even");
 }
 else
 {
	 out.print("odd");
 }%>
</body>
</html>