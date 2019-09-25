<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","capg","oracle123");
	PreparedStatement ps=con.prepareStatement("update userdetails set name=?,mobile=?  where email=?");
	ps.setString(1,request.getParameter("name"));
	ps.setString(2,request.getParameter("mobile"));
	
	ps.setString(3,request.getParameter("email"));
	int i=ps.executeUpdate();
	if(i==1){
		response.sendRedirect("home.jsp");
		
	}
	else{
		out.print("error in updating");
	}
	
}
catch(Exception e)
{
	e.printStackTrace();
}

%>
</body>
</html>