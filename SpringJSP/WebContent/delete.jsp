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

	PreparedStatement ps=con.prepareStatement("delete from userdetails where email=?");
	out.print(3);
	ps.setString(1,request.getParameter("email"));
	int i=ps.executeUpdate();
	if(i==1){
		response.sendRedirect("home.jsp");
		
	}
	else{
		out.print("error");
	}
	
}
catch(Exception e)
{
	e.printStackTrace();
}

%>
</body>
</html>