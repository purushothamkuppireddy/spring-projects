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
out.print("hi");
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
	out.print("1");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","capg","oracle123");
	out.print("2");
	PreparedStatement ps=con.prepareStatement("select * from userDetails where name=?");
	ps.setString(1,request.getParameter("name"));
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		out.print(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
	}
}
catch(Exception e)
{
	e.printStackTrace();
}

%>

</body>
</html>