<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hello <br><%=request.getParameter("name") %>
<%
try{
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","capg","oracle123");
	PreparedStatement ps=con.prepareStatement("insert into userDetails values(?,?,?)");
	ps.setString(1,request.getParameter("name"));
	ps.setString(2,request.getParameter("mobile"));
	ps.setString(3,request.getParameter("email"));
	int b=ps.executeUpdate();
	if(b==1){
		out.print("inserted");
		response.sendRedirect("home.jsp");
	}else{
			out.print("not inserted");
	}
}
catch(Exception e)
{
	e.printStackTrace();
}

%>




</body>
</html>