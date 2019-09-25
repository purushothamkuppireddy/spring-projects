<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>HEllo vjit</h1>

  <%! String s="Stupid ";int a=10,b=20;
int square(int x){
	return x*x;
}

%>

<%=s %>
<%=(a+b) %>
<%=square(5) %>

<%
if(s.length()>5)
{
	out.println("hello 5");
}
else
{
	out.println("not> 5");
}
%>

</body>
</html>